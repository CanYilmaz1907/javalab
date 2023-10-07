package ru.itis.dz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.dz.models.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
