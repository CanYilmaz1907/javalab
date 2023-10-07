package ru.itis.dz.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
public class MoviePage {
  private List<MovieDto> movies;
}
