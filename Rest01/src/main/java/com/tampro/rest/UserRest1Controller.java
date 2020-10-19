package com.tampro.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class UserRest1Controller {
//	@Autowired
//	UserService userService;
//	
//	@GetMapping(value = {"/users"})
//	public ResponseEntity<List<User>> getUsers(){
//		List<User> users = userService.getAll(null);
//		if(users == null ||	users.isEmpty() ) {
//			new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
//	}
//	
//	@GetMapping(value = {"/users/{id}"})
//	public ResponseEntity<User> getUser(@PathVariable("id") int id){
//		User user = userService.getById(id);
//		if(user == null ) {
//			new ResponseEntity<User>(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<User>(user,HttpStatus.OK);
//	}
//	@PostMapping(value = {"/users"})
//	public ResponseEntity<Void> addUser(@RequestBody User user){
//		try {
//			userService.insert(user);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return new ResponseEntity<Void>(HttpStatus.CREATED);
//	}
//	@PutMapping(value = {"/users"})
//	public ResponseEntity<User> updateUser(@RequestBody User user){
//		User currentUser = userService.getById(user.getId());
//		if(currentUser == null) {
//			return  new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//		}
//		try {
//			userService.update(user);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return new ResponseEntity<User>(currentUser,HttpStatus.OK);
//	}
//	@DeleteMapping(value = {"/users/{id}"})
//	public ResponseEntity<User> deleteUser(@PathVariable("id") int id){
//		User user = userService.getById(id);
//		if(user == null) {
//			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//		}
//		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
//	}
}
