package com.lcsouza.portifolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lcsouza.portifolio.entities.User;
import com.lcsouza.portifolio.repositories.UserRepository;

@SpringBootApplication
public class PortifolioApplication implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(PortifolioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User(1L, "livio");
		User user2 = new User(2L,"Anna");
		userRepository.save(user1);
		userRepository.save(user2);
		
		
	}

}
