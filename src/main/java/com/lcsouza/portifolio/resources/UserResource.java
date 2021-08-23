package com.lcsouza.portifolio.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcsouza.portifolio.entities.User;
import com.lcsouza.portifolio.repositories.UserRepository;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	 
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(){
		
		List<User> userList = userRepository.findAll();
		
		return ResponseEntity.ok().body(userList);
	}
	
	
	@GetMapping(value="/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		
		User user = userRepository.findById(id);
		return ResponseEntity.ok().body(user);
	}
	

}
