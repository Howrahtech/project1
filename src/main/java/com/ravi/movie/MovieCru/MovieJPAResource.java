package com.ravi.movie.MovieCru;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
@CrossOrigin(origins="http://localhost:6200")
@RestController
public class MovieJPAResource {

	@Autowired
	private MovieService movieService ;
	
	
	@Autowired
	private MovieJpaRepsitory movieJpaRepsitory;
	
	@GetMapping(path="/jpa/users/movie")
	public List<Movie> getAllMovie(){
		
	return	movieJpaRepsitory.findAll();
	//	return movieService.findAll();
		
	}
	

	
	
	
	@GetMapping(path="/jpa/users/movie/{id}")
	public Movie getMovie(@PathVariable long id){
		
		return movieJpaRepsitory.findById(id).get();
	//	return movieService.findById(id);
		
	}
	@DeleteMapping("/jpa/users/movie/{id}")
	public  ResponseEntity<Void>  deleteMovie(@PathVariable long id) {
		
		//Movie movie	=movieService.deleteById(id);
		movieJpaRepsitory.deleteById(id);
		/*
		 * if(movie!=null) { return ResponseEntity.noContent().build(); }
		 */
	//	return ResponseEntity.notFound().build();
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/jpa/users/movie/{id}")
	public  ResponseEntity<Movie>  updateMovie(@RequestBody Movie movie,@PathVariable long id) {
		
		
		movieJpaRepsitory.save(movie);
		
		//Movie updatedMovie=movieService.save(movie);
		return new ResponseEntity<Movie>(movie,HttpStatus.OK );
	}
	
	@PostMapping("/jpa/users/movie")
	public  ResponseEntity<Movie>  createMovie(@RequestBody Movie movie) {
		
		//Movie createdMovie=movieService.save(movie);
		
		
		Movie createdMovie=movieJpaRepsitory.save(movie);
		
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdMovie.getId()).toUri();
		
		return  ResponseEntity.created(uri).build();
	}
	
}
