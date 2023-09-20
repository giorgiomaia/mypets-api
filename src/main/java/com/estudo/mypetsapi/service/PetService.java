package com.estudo.mypetsapi.service;

import com.estudo.mypetsapi.dto.PetDTO;
import com.estudo.mypetsapi.entity.Pet;
import com.estudo.mypetsapi.repository.PetRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;

    public Pet criar(PetDTO petDTO) {
        Pet pet = new Pet();
        BeanUtils.copyProperties(petDTO, pet);
        return petRepository.save(pet);
    }

    public List<Pet> listar() {
        return petRepository.findAll();
    }

    public Pet buscar(Long id) {
        return petRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pet não encontrada com ID: " + id));
    }

    public Pet atualizar(PetDTO petDTO, Long id) {
        Pet pet = petRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pet não encontrada com ID: " + id));

        BeanUtils.copyProperties(petDTO,pet, "id");
        return petRepository.save(pet);
    }

    public void excluir(Long id) {
        if(!petRepository.existsById(id)) {
            throw new EntityNotFoundException("Pet não encontrado com ID: " + id);
        }
        petRepository.deleteById(id);
    }

}
