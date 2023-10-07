package ru.itis.dz.controllers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.dz.controllers.api.MovieApi;
import ru.itis.dz.dto.MovieCreatedPage;
import ru.itis.dz.dto.MovieDto;
import ru.itis.dz.dto.MoviePage;
import ru.itis.dz.impl.MovieService;

@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class MoviesController implements MovieApi {

  @Autowired
  private MovieService movieService;

  @Override
  public ResponseEntity<MovieCreatedPage> createMovie(Long cinemaId, MovieDto movieDto) {
    return ResponseEntity.ok(movieService.crateMovie(cinemaId, movieDto));
  }

  @Override
  public ResponseEntity<MoviePage> getMovies(Long cinemaId) {
    return ResponseEntity.ok(movieService.getMoviesFromCinema(cinemaId));
  }
}
