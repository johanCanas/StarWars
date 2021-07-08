package com.meli.joescaos.starwars.starwars.services;

import com.meli.joescaos.starwars.starwars.dtos.request.CharacterRequestDto;
import com.meli.joescaos.starwars.starwars.dtos.response.CharacterResponseDto;

import java.util.List;

public interface StarWarsService {

    List<String> getCharacter(CharacterRequestDto character);
}
