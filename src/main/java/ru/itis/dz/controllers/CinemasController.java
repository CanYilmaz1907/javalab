package ru.itis.dz.controllers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.dz.controllers.api.CinemaApi;
import ru.itis.dz.dto.CinemaPage;
import ru.itis.dz.impl.CinemaService;

@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CinemasController implements CinemaApi {

  @Autowired
  private CinemaService cinemaService;

  @Override
  public ResponseEntity<CinemaPage> getCinemas() {
    return ResponseEntity.ok(cinemaService.getCinemas());
  }
}
