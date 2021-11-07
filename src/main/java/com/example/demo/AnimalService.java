package com.example.demo;


import com.example.demo.common.AnimalValidator;
import com.example.demo.common.ErrorCode;
import com.example.demo.common.exceptions.AnimalNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class AnimalService {
    private final AnimalRepository animalRepository;
    private final AnimalValidator validator;

    public Animal createAnimal(AnimalForm form) {
        validator.validate(form);
        Animal animal = new Animal();
        animal.setKinds(form.getKinds());
        animal.setName(form.getName());
        return animalRepository.save(animal);
    }

    public Animal getAnimal(Long id) {
        Animal animal = animalRepository.findById(id).orElseThrow(() ->
                new AnimalNotFoundException(ErrorCode.ANIMAL_NOT_FOUND.getErrorMessage(),
                        ErrorCode.ANIMAL_NOT_FOUND.getErrorCode()));
        return animal;
    }
}
