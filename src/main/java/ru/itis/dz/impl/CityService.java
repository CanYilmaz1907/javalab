package ru.itis.dz.impl;

import ru.itis.dz.dto.CityCreatedPage;
import ru.itis.dz.dto.CityDto;
import ru.itis.dz.dto.CityPage;

public interface CityService {
  CityPage getCities();
  CityCreatedPage createCity(CityDto cityDto);
}
