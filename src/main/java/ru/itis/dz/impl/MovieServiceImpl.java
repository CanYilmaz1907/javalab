package ru.itis.dz.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.dz.dto.MovieCreatedPage;
import ru.itis.dz.dto.MovieDto;
import ru.itis.dz.dto.MoviePage;
import ru.itis.dz.models.Cinema;
import ru.itis.dz.models.Movie;
import ru.itis.dz.repositories.CinemaRepository;
import ru.itis.dz.repositories.MovieRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService{

  @Autowired
  MovieRepository movieRepository;

  @Autowired
  CinemaRepository cinemaRepository;

  @Override
  public MovieCreatedPage crateMovie(Long cinemaId, MovieDto movieDto) {

    Cinema cinema = cinemaRepository.findById(cinemaId).get();

    Movie movie = Movie.builder()
            .cinema(cinema)
            .title(movieDto.getTitle())
            .description(movieDto.getDescription())
            .build();

    MovieDto responseMovie;

    if((responseMovie = MovieDto.from(movieRepository.save(movie))) != null){
      return MovieCreatedPage
              .builder()
              .movie(responseMovie)
              .message("Movie created!")
              .build();
    }
    else {
      return MovieCreatedPage
              .builder()
              .message("Movie not created!")
              .build();
    }

  }

  @Override
  public MoviePage getMoviesFromCinema(Long cinemaID) {
    Cinema cinema = cinemaRepository.findById(cinemaID).get();

    List<MovieDto> movies = cinema
            .getMovies()
            .stream()
            .map(movie -> MovieDto.from(movie))
            .toList();

    return MoviePage
                    .builder()
                    .movies(movies)
                    .build();
  }
}
