package ru.itis.dz.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "This is the page showed when a city is created")
public class CityCreatedPage {

  @Schema(description = "The error or success message")
  private String message;

  @Schema(description = "the city object created")
  private CityDto city;
}

