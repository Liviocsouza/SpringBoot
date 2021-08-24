package com.lcsouza.portifolio.resources;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcsouza.portifolio.entities.Empresa;
import com.lcsouza.portifolio.entities.User;
import com.lcsouza.portifolio.repositories.UserRepository;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	 
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public List<User> findAll(){
		
		return userRepository.findAll();
	}
	

	@GetMapping(value="/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		
		User user = userRepository.findById(id).get();
		return ResponseEntity.ok().body(user);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> atualizar(@PathVariable Long id, 
			 @RequestBody User user) {
		User existente = userRepository.getById(id);
		
		if (existente == null) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(user, existente, "id");
		
		existente = userRepository.save(existente);
		
		return ResponseEntity.ok(existente);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		User existente = userRepository.getById(id);
		
		if (existente == null) {
			return ResponseEntity.notFound().build();
		}
		
		userRepository.delete(existente);
		
		return ResponseEntity.noContent().build();
	}
	
	

}
