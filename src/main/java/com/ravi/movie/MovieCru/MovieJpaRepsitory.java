package com.ravi.movie.MovieCru;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MovieJpaRepsitory  extends JpaRepository<Movie, Long> {

}
