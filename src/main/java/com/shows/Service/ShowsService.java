package com.shows.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.shows.Entity.Shows;
import com.shows.Repository.ShowsRepository;

@Service
public class ShowsService {

	private final ShowsRepository showsRepository;

	public ShowsService(ShowsRepository showsRepository) {
		this.showsRepository = showsRepository;
	}

	public Shows salvaShows (Shows shows) {
		return showsRepository.save(shows);
	}

	public Shows getShowsById(Long id) {
		return showsRepository.findById(id).orElse(null);
	}

	public List<Shows> getShowsAll() {
		return showsRepository.findAll();

	}
	public Shows alterarShows(Long id, Shows alterarShows) {
		Optional<Shows> existeShows = showsRepository.findById(id);
		if(existeShows.isPresent()) {
			alterarShows.setId(id);
			return showsRepository.save(alterarShows);
		} else {
			return null;
		}
	}
	public boolean deleteShows(Long id) {
		Optional<Shows> existeShows = showsRepository.findById(id);
		if (existeShows.isPresent() ) {
			showsRepository.deleteById(id);
			return true;
		} else {
			return false;
		}


	}
}


