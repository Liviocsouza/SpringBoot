package com.lcsouza.portifolio.resources;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.lcsouza.portifolio.entities.Empresa;
import com.lcsouza.portifolio.repositories.EmpresaRepository;

@RestController
@RequestMapping(value="/empresas")
public class EmpresaResource {
	 
	@Autowired
	private EmpresaRepository empresaRepository;
	
	@PostMapping
	public Empresa adicionar(@RequestBody Empresa empresa) {
		
		return empresaRepository.save(empresa);
	}
	
	
	@GetMapping
	public List<Empresa> findAll(){
		
		
		return empresaRepository.findAll();
	}
	
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Empresa> findById(@PathVariable Long id){
		
		Empresa empresa = empresaRepository.findById(id).get();
		return ResponseEntity.ok().body(empresa);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Empresa> atualizar(@PathVariable Long id, 
			 @RequestBody Empresa empresa) {
		Empresa existente = empresaRepository.getById(id);
		
		if (existente == null) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(empresa, existente, "id");
		
		existente = empresaRepository.save(existente);
		
		return ResponseEntity.ok(existente);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		Empresa empresa = empresaRepository.getById(id);
		
		if (empresa == null) {
			return ResponseEntity.notFound().build();
		}
		
		empresaRepository.delete(empresa);
		
		return ResponseEntity.noContent().build();
	}
	

}
