package com.meli.joescaos.starwars.starwars.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class CharacterRequestDto {

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name must have at least one letter")
    private String name;
}
