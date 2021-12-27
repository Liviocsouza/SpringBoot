package lc.souza.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lc.souza.springboot.domain.Anime;
import lc.souza.springboot.service.AnimeService;

@RestController
@RequestMapping("animes")
public class AnimeController {
	
	@Autowired
	private  AnimeService animeService;
	
	
	@GetMapping
	public ResponseEntity<List<Anime>> list(){
		
		return ResponseEntity.ok(animeService.listAll());
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Anime> findById(@PathVariable long id){
		
		return ResponseEntity.ok(animeService.findById(id));
	}
	
	

}
