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
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.dz.dto.CinemaPage;

@RequestMapping("/api/cinemas")
@Tags(value =
@Tag(name = "cinemas"))
public interface CinemaApi {
  @Operation(summary = "We get a list of the cinemas without the city they belong", description = "Available for all users")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Запрос обработан успешно",
                  content = {
                          @Content(mediaType = "application/json", schema = @Schema(implementation = CinemaPage.class))
                  })
  })
  @GetMapping
  ResponseEntity<CinemaPage> getCinemas();
}
