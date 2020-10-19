package com.tampro.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tampro.entity.ConfirmationToken;
import com.tampro.entity.User;
import com.tampro.service.ConfirmationTokenService;
import com.tampro.service.UserReport;
import com.tampro.service.UserService;

@Controller
public class HomeController {

	@Autowired
	UserService userService;
	@Autowired
	JavaMailSender javaMailSender;
	@Autowired
	ConfirmationTokenService confirmationTokenService;
	@GetMapping("/home")
	public String home(Model model) {
		List<User> list = userService.getAll(null);
		model.addAttribute("list", list);
		return "index";
	}
	@GetMapping("/export")
	public ModelAndView  export(Model model) {
		List<User> users = userService.getAll(null);
		return new ModelAndView(new UserReport(), "listUser", users);
	}
	// file xls . 1 sheet là trang tính của file excel
	// Row  = sheet tạo ra  
	 // row tạo ra cell và set cell
	@GetMapping("/add")
	public ModelAndView addUser(Model model) {
		ModelAndView modelAndView = new ModelAndView("action");
		modelAndView.addObject("submitForm", new User());
		return modelAndView;
	}
	@GetMapping("/report")
	@ResponseBody
	public String report(Model model) throws Exception {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.getSheet("0");
		for(int i = 1 ; i <  sheet.getPhysicalNumberOfRows() ; i++) {
			HSSFRow row = sheet.createRow(i);
			User user = new User();
			user.setEmail(row.getCell(0).getStringCellValue());
			user.setName(row.getCell(1).getStringCellValue());
			user.setUsername(row.getCell(2).getStringCellValue());
			user.setPassword(row.getCell(3).getStringCellValue());
			userService.insert(user);
		}
		return "report";
	}
	@PostMapping("/save")
	public String saveUser(@ModelAttribute("submitForm") User user,HttpServletRequest request) throws Exception {
		ConfirmationToken token = new ConfirmationToken(user);
		//save token vào database  1- 1 user
		userService.insert(user);
		confirmationTokenService.add(token);
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(user.getEmail());
		message.setSubject("	Complete Registration	");
		message.setText("To confirm your account, please click here : "+"http://localhost:8080/Rest01/confirm-account?token="+token.getConfirmationToken());
		javaMailSender.send(message);
		
				/*
		MimeMessage message = emailSender.createMimeMessage();	     
	    MimeMessageHelper helper = new MimeMessageHelper(message, true);	    
	    helper.setFrom("noreply@baeldung.com");
	    helper.setTo(to);
	    helper.setSubject(subject);
	    helper.setText(text);	        
	    FileSystemResource file 
	      = new FileSystemResource(new File(pathToAttachment));
	    helper.addAttachment("Invoice", file);	 
	    emailSender.send(message);
		 		*/
		return "redirect:/home";
	}
	@GetMapping("/confirm-account")
	@ResponseBody
	public String confirmAccount(Model model,@RequestParam("token") String token) {
		ConfirmationToken confirmationToken = confirmationTokenService.findByToken(token);
		if(confirmationToken != null) {
			//set enable user;
			return "Thành công";
		}else {
			return "Thất bại";
		}		
	}
}
