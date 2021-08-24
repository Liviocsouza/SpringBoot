package com.lcsouza.portifolio.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.lcsouza.portifolio.entities.Empresa;

@Component
public class EmpresaRepository {
	
	private Map<Long,Empresa> map = new HashMap<Long, Empresa>();
	
	public void save(Empresa obj) {
		map.put(obj.getId(), obj);
		
	}
	
	public Empresa findById(Long id) {
		
		return map.get(id);
	}
	
	public List<Empresa> findAll(){
		return new ArrayList<Empresa>(map.values());
		
	}

}
