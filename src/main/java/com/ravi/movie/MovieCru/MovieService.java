package com.ravi.movie.MovieCru;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MovieService {

	
	
	
	private static List<Movie> movies = new ArrayList();
	private static long cnt=0;
	static {
	//	movies.add(new Movie(++cnt,"lion king","story of lion",new Date(),5,"assets/img/lion_king.jpg"));
	//	movies.add(new Movie(++cnt,"spyder","story of truth",new Date(),4,"assets/img/spyder.jpg"));
	//	movies.add(new Movie(++cnt,"avenger","story of heroes",new Date(),4,"assets/img/avenger.jpg"));
		
	}
	
	
	public List<Movie>  findAll(){
		
		return movies;
	}
	
	public Movie save(Movie movie) {
		
		if(movie.getId()==-1 || movie.getId()==-0) {
		movie.setId(++cnt);
			movies.add(movie);	
			
		} 
		else {
			deleteById(movie.getId());
			movies.add(movie);
		}
		return movie;
	}
	
	public Movie deleteById(long id) {
		
		Movie movie=findById(id);
		if(movie==null) return null;
		if(movies.remove(movie)) {
			
			return movie ;}
		return null;
	}

	public Movie findById(long id) {
		for(Movie movie:movies) {
			if(movie.getId()==id) {
				return movie;
			}
		}
		
		
		
		return null;
	}
}
