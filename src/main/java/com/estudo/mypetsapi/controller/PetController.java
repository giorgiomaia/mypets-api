package com.estudo.mypetsapi.controller;

import com.estudo.mypetsapi.entity.Pet;
import com.estudo.mypetsapi.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping
    public ResponseEntity<Pet> listar() {
        List<Pet> pets = petService.listar();
        return null;
    }

}
