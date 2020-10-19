package com.tampro.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tampro.entity.User;
import com.tampro.service.UserService;
@RestController
@RequestMapping("/rest")
public class UserResetController {
		@Autowired
		UserService userService;
		

		@GetMapping(value= {"/users"},produces = { MediaType.APPLICATION_JSON_VALUE
				,MediaType.APPLICATION_XML_VALUE}) // dữ liệu trao đổi giữa client và restful là json hoăc xml
		public List<User> getUsers() {
			return userService.getAll(null);
		}
		@GetMapping(value= {"/users/search/{name}"},produces = { MediaType.APPLICATION_JSON_VALUE
				,MediaType.APPLICATION_XML_VALUE}) // dữ liệu trao đổi giữa client và restful là json hoăc xml
		public List<User> getUsersSearch(@PathVariable("search") String search) {
			User user = new User();
			user.setName(search);
			return userService.getAll(user);
		}
		@GetMapping(value = {"/users/{id}"},produces = MediaType.APPLICATION_JSON_VALUE)
		public User getUser(@PathVariable("id") int id) {
			return userService.getById(id);
		}
		@PostMapping(value = {"/users"},produces = {MediaType.APPLICATION_JSON_VALUE
				,MediaType.APPLICATION_XML_VALUE})
		public User	 addUser(@RequestBody User user) {
			System.out.println("create user"+user.getUsername());
			try {
				userService.insert(user);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return user;
		}
		@PutMapping(value = {"/users"},produces = {MediaType.APPLICATION_JSON_VALUE
				,MediaType.APPLICATION_XML_VALUE})
		public User	 updateUser(@RequestBody User user) {
			System.out.println("update user"+user.getUsername());
			try {
				userService.update(user);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return user;
		}
		@DeleteMapping(value = {"/users/{id}"})
		public String	 deleteUser(@PathVariable("id") int id) {
			User user = 	userService.getById(id);
			System.out.println("delete user"+user.getUsername());
			try {
				userService.delete(user);
				return "success";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "error";
		}
}
