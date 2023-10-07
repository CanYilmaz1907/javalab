package ru.itis.dz.controllers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.dz.controllers.api.CityApi;
import ru.itis.dz.dto.CityCreatedPage;
import ru.itis.dz.dto.CityDto;
import ru.itis.dz.dto.CityPage;
import ru.itis.dz.impl.CityService;

@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CitiesController implements CityApi {

  @Autowired
  private CityService cityService;

  @Override
  public ResponseEntity<CityPage> getCities() {
    return ResponseEntity.ok(cityService.getCities());
  }

  @Override
  public ResponseEntity<CityCreatedPage> createCity(CityDto cityDto) {
    return ResponseEntity.ok(cityService.createCity(cityDto));
  }
}
