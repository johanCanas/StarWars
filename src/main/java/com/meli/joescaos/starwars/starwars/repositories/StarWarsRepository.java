package com.meli.joescaos.starwars.starwars.repositories;

import com.meli.joescaos.starwars.starwars.dtos.request.CharacterRequestDto;
import com.meli.joescaos.starwars.starwars.dtos.response.CharacterResponseDto;

import java.util.List;

public interface StarWarsRepository {

    List<CharacterResponseDto> getCharacterByString(CharacterRequestDto characterRequestDto);
}
