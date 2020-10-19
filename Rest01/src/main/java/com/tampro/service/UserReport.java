package com.tampro.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.tampro.entity.User;

public class UserReport extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String fileName = "user-export-"+System.currentTimeMillis()+".xls";
		response.setHeader("Content-Disposition", "attachment;filename=\""+fileName+"\"");
		Sheet sheet = workbook.createSheet("data");
		sheet.setDefaultColumnWidth(30);
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("#");
		header.createCell(1).setCellValue("Id");
		header.createCell(2).setCellValue("Username");
		header.createCell(3).setCellValue("Password");
		header.createCell(4).setCellValue("Name");
		header.createCell(5).setCellValue("Email");
		List<User> users =(List<User>) model.get("listUser");
		int rownum=1;
		for(User user :users) {
			Row row = sheet.createRow(rownum++);
			row.createCell(0).setCellValue(rownum-1);
			row.createCell(1).setCellValue(user.getId());
			row.createCell(2).setCellValue(user.getUsername());
			row.createCell(3).setCellValue(user.getPassword());
			row.createCell(4).setCellValue(user.getName());
			row.createCell(5).setCellValue(user.getEmail());
			
		}
	}

}
