package ru.itis.dz.dto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "page shown when movie is created")
public class MovieCreatedPage {
  private MovieDto movie;
  private String message;
}
