package com.meli.joescaos.starwars.starwars.controllers;

import com.meli.joescaos.starwars.starwars.dtos.request.CharacterRequestDto;
import com.meli.joescaos.starwars.starwars.services.StarWarsService;
import com.meli.joescaos.starwars.starwars.services.impl.StarWarsServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/starwars")
public class StarWarsController {

    private final StarWarsService starWarsService;

    public StarWarsController(StarWarsService starWarsService) {
        this.starWarsService = starWarsService;
    }

    @PostMapping("/find")
    public ResponseEntity<Object> find(@Valid @RequestBody CharacterRequestDto character){
        return new ResponseEntity<>(starWarsService.getCharacter(character), HttpStatus.OK);
    }
}
