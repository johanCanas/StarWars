package com.meli.joescaos.starwars.starwars.repositories.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.joescaos.starwars.starwars.dtos.request.CharacterRequestDto;
import com.meli.joescaos.starwars.starwars.dtos.response.CharacterResponseDto;
import com.meli.joescaos.starwars.starwars.models.Character;
import com.meli.joescaos.starwars.starwars.repositories.StarWarsRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StarWarsRepositoryImpl implements StarWarsRepository {

    @Override
    public List<CharacterResponseDto> getCharacterByString(CharacterRequestDto characterRequestDto) {
        List<CharacterResponseDto> characters = loadDataBase();
        return characters.stream().filter(character -> character.getName()
                .contains(characterRequestDto.getName()))
                .collect(Collectors.toList());
    }

    private List<CharacterResponseDto> loadDataBase(){
        File file = null;
        try{
            file = ResourceUtils.getFile("classpath:static/starwars.json");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        return mapObject(file);
    }

    private List<CharacterResponseDto> mapObject(File file){
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CharacterResponseDto>> typeReference = new TypeReference<>(){};
        List<CharacterResponseDto> characters = null;
        try {
            characters = objectMapper.readValue(file, typeReference);
        }catch (IOException e){
            e.printStackTrace();
        }

        return characters;
    }

}
