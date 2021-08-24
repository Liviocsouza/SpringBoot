package com.lcsouza.portifolio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lcsouza.portifolio.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	

}
