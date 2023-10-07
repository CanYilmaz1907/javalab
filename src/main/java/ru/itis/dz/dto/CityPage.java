package ru.itis.dz.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "We get all cities with their hotels")
public class CityPage {
  @Schema(description = "a list of cities")
  private List<CityDto> cities;

}
