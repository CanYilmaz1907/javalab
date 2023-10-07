package ru.itis.dz.controllers.api;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.dz.dto.CityCreatedPage;
import ru.itis.dz.dto.CityDto;
import ru.itis.dz.dto.CityPage;

@RequestMapping("/api/cities")
@Tags(value =
@Tag(name = "cities"))
public interface CityApi {
  @Operation(summary = "We get a list of the cities", description = "Available for all users")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Запрос обработан успешно",
                  content = {
                          @Content(mediaType = "application/json", schema = @Schema(implementation = CityPage.class))
                  })
  })
  @GetMapping
  ResponseEntity<CityPage> getCities();

  @PostMapping
  ResponseEntity<CityCreatedPage> createCity(@RequestBody CityDto cityDto);
}
