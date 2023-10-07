package ru.itis.dz.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.dz.dto.CinemaDto;
import ru.itis.dz.dto.CinemaPage;
import ru.itis.dz.repositories.CinemaRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CinemaServiceImpl implements CinemaService{

  @Autowired
  private CinemaRepository cinemaRepository;

  @Override
  public CinemaPage getCinemas() {
    List<CinemaDto> cinemas = cinemaRepository
            .findAll()
            .stream()
            .map(cinema -> CinemaDto.from(cinema))
            .toList();

    return CinemaPage
            .builder()
            .cinemas(cinemas)
            .build();
  }
}
