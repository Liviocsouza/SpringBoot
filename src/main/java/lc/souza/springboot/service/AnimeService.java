package lc.souza.springboot.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lc.souza.springboot.domain.Anime;

@Service
public class AnimeService {
	private List<Anime> animes = List.of(new Anime(1L, "One piece"), new Anime(2L, "Naruto"));

	public List<Anime> listAll() {
		return animes;

	}

	public Anime findById(long id) {
		return animes.stream()
				.filter(anime -> anime.getId().equals(id)).findFirst()
				.orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime not Found"));

	}

}
