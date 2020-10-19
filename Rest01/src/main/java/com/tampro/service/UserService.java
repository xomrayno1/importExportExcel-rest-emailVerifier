package com.tampro.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.tampro.dao.UserDAO;
import com.tampro.entity.User;

@Service
public class UserService {
	@Autowired
	UserDAO userDAO;
	@Autowired
	ServletContext servletContext;
	

	
	public void insert(User user) throws Exception{
		if(!user.getMultipartFile().isEmpty()) {
			String nameImg =  System.currentTimeMillis() +"_"+ user.getMultipartFile().getOriginalFilename();
			//String fileName = servletContext.getRealPath("/") +"static\\upload\\"+ nameImg;
			uploadFile(user.getMultipartFile(), nameImg);
			//user.getMultipartFile().transferTo(new File(fileName));
			user.setImg("/static/upload/"+nameImg);
			
		}
		userDAO.insert(user);
	}
	
	public void uploadFile(MultipartFile multipartFile , String img) {
		String pathFolder = "D:\\EclipseProject\\Rest01\\src\\main\\webapp\\static\\upload\\";
		String fileName = servletContext.getRealPath("/") +"static\\upload\\";
		File file = new File(fileName + img);
		if(!multipartFile.isEmpty()) {
			try {
				byte[] bytes = multipartFile.getBytes();
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(file));
				multipartFile.transferTo(new File(pathFolder));
				stream.write(bytes);
				stream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	public	void update(User user) throws Exception{
		userDAO.update(user);
	}
	public	void delete(User user) throws Exception{
		userDAO.delete(user);
	};
	public	List<User> getAll(User user){
		StringBuilder stringStr = new StringBuilder("");
		Map<String,Object> mapParam = new HashedMap<String, Object>();
		if(user != null) {
			if(!user.getUsername().isEmpty()) {
				stringStr.append("	and us.username =:username");
				mapParam.put("username", user.getUsername());
			}
			if(!user.getUsername().isEmpty()) {
				stringStr.append("	and us.name  like :name");
				mapParam.put("name", '%'+user.getUsername()+'%');
			}
		}
		return userDAO.findAll(stringStr.toString(), mapParam);
	}
	public	List<User> getAllByProperty(String property , Object object){
		return userDAO.findAllByProperty(property, object);
	}
	public	User getById(int id) {
		return userDAO.findById(id);
	}
}
