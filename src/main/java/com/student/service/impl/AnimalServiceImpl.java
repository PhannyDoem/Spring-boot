package com.student.service.impl;

import com.student.model.Animal;
import com.student.repository.AnimalRepository;
import com.student.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AnimalServiceImpl implements AnimalService {
    @Autowired
    private AnimalRepository animalRepository;

    @Override
    public Animal saveAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public Optional<Animal> getAnimalById(Long id) {
        return animalRepository.findById(id);
    }

    @Override
    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    @Override
    public Animal updateAnimal(long id, Animal animal) {
        return animalRepository.findById(id)
                .map(animal1 -> {
                    animal1.setName(animal.getName());
                    animal1.setColor(animal.getColor());
                    animal1.setAge(animal.getAge());
                    return animalRepository.save(animal1);
                }).orElse( null);
    }

    @Override
    public String deleteAnimal(long id) {
        animalRepository.deleteById(id);
        return "Animal Deleted Successfully";
    }
}
