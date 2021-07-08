package com.meli.joescaos.starwars.starwars.services.impl;

import com.meli.joescaos.starwars.starwars.dtos.request.CharacterRequestDto;
import com.meli.joescaos.starwars.starwars.dtos.response.CharacterResponseDto;
import com.meli.joescaos.starwars.starwars.repositories.StarWarsRepository;
import com.meli.joescaos.starwars.starwars.services.StarWarsService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class StarWarsServiceImpl implements StarWarsService {

    public final StarWarsRepository starWarsRepository;

    public StarWarsServiceImpl(StarWarsRepository starWarsRepository) {
        this.starWarsRepository = starWarsRepository;
    }

    @Override
    public List<String> getCharacter(CharacterRequestDto character) {
       List<CharacterResponseDto> characters = starWarsRepository.getCharacterByString(character);
       List<String> names = new ArrayList<>();
       for (CharacterResponseDto characterResponseDto: characters){
           names.add(characterResponseDto.getName());
       }

       return names;
    }
}
