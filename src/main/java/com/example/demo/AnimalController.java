package com.example.demo;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AnimalController {
    private final AnimalService service;

    @PostMapping("/animal")
    public ResponseEntity createAnimal(@RequestBody AnimalForm form) {
        Animal animal = service.createAnimal(form);
        return ResponseEntity.ok().body(animal);
    }

    @GetMapping("/animal/{id}")
    public ResponseEntity getAnimal(@PathVariable Long id) {
        Animal animal = service.getAnimal(id);
        return ResponseEntity.ok().body(animal);
    }
}
