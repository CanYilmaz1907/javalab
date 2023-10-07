package ru.itis.dz.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.dz.models.Cinema;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "The cinema")
public class CinemaDto {
  private Long id;

  private String name;

  private List<MovieDto> movies;

  public static CinemaDto from(Cinema cinema){
    return CinemaDto
            .builder()
            .id(cinema.getId())
            .name(cinema.getName())
            .movies(cinema
                    .getMovies()
                    .stream()
                    .map(movie -> MovieDto.from(movie))
                    .toList())
            .build();
  }
}
