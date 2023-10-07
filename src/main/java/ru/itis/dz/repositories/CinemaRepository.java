package ru.itis.dz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.dz.models.Cinema;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {
}
