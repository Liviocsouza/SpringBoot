package lc.souza.springboot.repository;

import java.util.List;

import lc.souza.springboot.domain.Anime;

public interface AnimeRepository {
	List<Anime> listAll();

}
