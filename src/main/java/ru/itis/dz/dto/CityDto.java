package ru.itis.dz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.dz.models.City;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(name = "City", description = "A object for cities")
public class CityDto {

  private Long id;

  @JsonProperty("name")
  private String name;
  @JsonProperty("location")
  private String location;

  private List<CinemaDto> cinemas;

  public static CityDto from(City city){

    CityDto cityDto = CityDto.builder()
            .id(city.getId())
            .name(city.getName())
            .location(city.getLocation())
            .build();


    if(city.getCinemas() != null){
      cityDto.setCinemas(city
              .getCinemas()
              .stream()
              .map(cinema -> CinemaDto.from(cinema))
              .toList());
    }
    return cityDto;
  }
}
