package com.student.controller;

import com.student.model.Animal;
import com.student.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @PostMapping("/animal")
    public ResponseEntity<Animal> saveAnimal(@RequestBody Animal animal){
        Animal savedAnimal = animalService.saveAnimal(animal);
        return new ResponseEntity<>(savedAnimal, HttpStatus.CREATED);
    }

    @GetMapping("/animal/{id}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable Long id){
        Optional<Animal> animal = animalService.getAnimalById(id);
        return animal.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/animal/{id}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable Long id, @RequestBody Animal animalDetails){
        Animal updatedAnimal = animalService.updateAnimal(id, animalDetails);
        return updatedAnimal != null ? new ResponseEntity<>(updatedAnimal, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/animal/{id}")
    public ResponseEntity<String> deleteAnimal(@PathVariable Long id){
        String response = animalService.deleteAnimal(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/animals")
    public ResponseEntity<List<Animal>> getAllAnimals(){
        List<Animal> animals = animalService.getAllAnimals();
        return new ResponseEntity<>(animals, HttpStatus.OK);
    }
}
