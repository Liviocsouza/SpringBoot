package com.lcsouza.portifolio.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.lcsouza.portifolio.entities.User;

@Component
public class UserRepository {
	
	private Map<Long,User> map = new HashMap<Long, User>();
	
	public void save(User user) {
		map.put(user.getId(), user);
		
	}
	
	public User findById(Long id) {
		
		return map.get(id);
	}
	
	public List<User> findAll(){
		return new ArrayList<User>(map.values());
		
	}

}
