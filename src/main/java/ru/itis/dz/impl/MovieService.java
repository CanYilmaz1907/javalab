package ru.itis.dz.impl;

import ru.itis.dz.dto.MovieCreatedPage;
import ru.itis.dz.dto.MovieDto;
import ru.itis.dz.dto.MoviePage;

public interface MovieService {
  MovieCreatedPage crateMovie(Long cinemaId, MovieDto movieDto);
  MoviePage getMoviesFromCinema(Long cinemaID);
}

