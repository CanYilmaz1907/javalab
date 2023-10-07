package ru.itis.dz.controllers.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.itis.dz.dto.MovieCreatedPage;
import ru.itis.dz.dto.MovieDto;
import ru.itis.dz.dto.MoviePage;

@RequestMapping(path = "/api/cinemas/{cinema_id}/movies")
public interface MovieApi {
  @Operation(summary = "We get a list of the cinemas without the city they belong", description = "Available for all users")
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "Запрос обработан успешно",
                  content = {
                          @Content(mediaType = "application/json", schema = @Schema(implementation = MovieCreatedPage.class))
                  })
  })

  @PostMapping
  ResponseEntity<MovieCreatedPage> createMovie(@PathVariable("cinema_id") Long cinemaId, @RequestBody MovieDto movieDto);

  @GetMapping
  ResponseEntity<MoviePage> getMovies(@PathVariable("cinema_id") Long cinemaId);

}
