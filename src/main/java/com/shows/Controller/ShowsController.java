package com.shows.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shows.Entity.Shows;
import com.shows.Service.ShowsService;



@RestController
@RequestMapping("/pet")

public class ShowsController {
	
	private final ShowsService showsService;
	
	public ShowsController(ShowsService showsService) {
		this.showsService = showsService;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Shows>> getAllShows() {
		List<Shows> shows = showsService.getShowsAll();
		return ResponseEntity.ok(shows);
		
	}
	
	@GetMapping("/{id}")
    public ResponseEntity<Shows> getShowsById(@PathVariable Long id) {
        Shows shows = showsService.getShowsById(id);
        if (shows != null) {
            return ResponseEntity.ok(shows);
        } else {
            return ResponseEntity.notFound().build();
        }
		
	}
	
	@PostMapping("/")
	public ResponseEntity<Shows> criarShows(@RequestBody Shows shows) {
		Shows criarShows = showsService.salvaShows(shows);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarShows);
	}
	
	 @PutMapping("/{id}")
	    public ResponseEntity<Shows> alterarShows(@PathVariable Long id, @RequestBody Shows shows) {
	        Shows alterarShows = showsService.alterarShows(id, shows);
	        if (shows != null) {
	            return ResponseEntity.ok(alterarShows);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	 }
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteShows (@PathVariable Long id) {
		boolean deleted = showsService.deleteShows(id);
		if(deleted) {
			return ResponseEntity.ok().body("Show cancelado com sucesso");
		}else {
			return ResponseEntity.notFound().build();
		}
	}

	

}
