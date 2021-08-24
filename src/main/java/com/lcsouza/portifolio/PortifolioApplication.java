package com.lcsouza.portifolio;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lcsouza.portifolio.entities.Empresa;
import com.lcsouza.portifolio.entities.User;
import com.lcsouza.portifolio.repositories.EmpresaRepository;
import com.lcsouza.portifolio.repositories.UserRepository;

@SpringBootApplication
public class PortifolioApplication implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private EmpresaRepository empresaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(PortifolioApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Empresa unimedFort = new Empresa(1L,"Unimed Fortaleza",12341L);
		Empresa unimedCeara = new Empresa(2L, "Unimed Ceara", 1211L);
		
		User user1 = new User(1L, "livio",unimedFort);
		User user2 = new User(2L,"Anna",unimedCeara);
		User user3 = new User(3L,"Bruno",unimedCeara);
		User user4 = new User(4L,"Laura",unimedFort);
		
		unimedFort.getUsers().add(user1);
		unimedCeara.getUsers().addAll(Arrays.asList(user2,user3));
		
		empresaRepository.save(unimedCeara);
		empresaRepository.save(unimedFort);

		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);
		userRepository.save(user4);
		
		
	}

}
