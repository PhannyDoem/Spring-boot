package com.student.service;

import com.student.model.Animal;

import java.util.List;
import java.util.Optional;

public interface AnimalService {
    Animal saveAnimal(Animal animal);

    Optional<Animal> getAnimalById(Long id);

    List<Animal> getAllAnimals();

    Animal updateAnimal(long id, Animal animal);

    String deleteAnimal(long id);
}
