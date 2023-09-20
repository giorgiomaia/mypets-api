package com.estudo.mypetsapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PetDTO {

    @NotBlank(message = "O nome é obrigatório")
    private String nome;

    @Past(message = "A data de nascimento deve ser no passado")
    private LocalDate dataNascimento;
}
