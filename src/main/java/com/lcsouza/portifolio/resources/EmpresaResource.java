package com.lcsouza.portifolio.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcsouza.portifolio.entities.Empresa;
import com.lcsouza.portifolio.repositories.EmpresaRepository;

@RestController
@RequestMapping(value="/empresas")
public class EmpresaResource {
	 
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@GetMapping
	public ResponseEntity<List<Empresa>> findAll(){
		
		List<Empresa> userList = empresaRepository.findAll();
		
		return ResponseEntity.ok().body(userList);
	}
	
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Empresa> findById(@PathVariable Long id){
		
		Empresa empresa = empresaRepository.findById(id).get();
		return ResponseEntity.ok().body(empresa);
	}
	

}
