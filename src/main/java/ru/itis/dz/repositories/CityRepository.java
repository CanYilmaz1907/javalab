package ru.itis.dz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.dz.models.City;

public interface CityRepository extends JpaRepository<City, Long> {
}
