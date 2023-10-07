package ru.itis.dz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.dz.models.Movie;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "movies")
public class MovieDto {

  private Long id;

  @JsonProperty("title")
  private String title;
  @JsonProperty("description")
  private String description;

  public static MovieDto from(Movie movie){
    return MovieDto
            .builder()
            .id(movie.getId())
            .title(movie.getTitle())
            .description(movie.getDescription())
            .build();
  }
}
