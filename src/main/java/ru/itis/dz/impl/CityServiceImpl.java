package ru.itis.dz.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.dz.dto.CityCreatedPage;
import ru.itis.dz.dto.CityDto;
import ru.itis.dz.dto.CityPage;
import ru.itis.dz.models.City;
import ru.itis.dz.repositories.CityRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService{
  @Autowired
  private CityRepository cityRepository;

  @Override
  public CityPage getCities() {
    List<CityDto> cities = cityRepository
            .findAll()
            .stream()
            .map(city -> CityDto.from(city))
            .toList();

    return CityPage.builder()
            .cities(cities)
            .build();
  }

  @Override
  public CityCreatedPage createCity(CityDto cityDto) {
    City city = City
            .builder()
            .name(cityDto.getName())
            .location(cityDto.getLocation())
            .build();

    City cityDtoSaved = null;

    if((cityDtoSaved = cityRepository.save(city)) != null){
      return CityCreatedPage
              .builder()
              .message("City created successfully")
              .city(CityDto.from(cityDtoSaved))
              .build();
    }
    else{
      return CityCreatedPage
              .builder()
              .message("Something went wrong")
              .build();
    }
  }
}
