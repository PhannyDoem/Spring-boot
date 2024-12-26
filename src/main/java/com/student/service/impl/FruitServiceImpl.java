package com.student.service.impl;

import com.student.model.Fruit;
import com.student.repository.FruitRepository;
import com.student.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitServiceImpl implements FruitService {
    @Autowired
    private FruitRepository fruitRepository;


    @Override
    public Fruit saveFruit(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public Optional<Fruit> getFruitById(Long id) {
        return fruitRepository.findById(id);
    }

    @Override
    public List<Fruit> getAllFruits() {
        return fruitRepository.findAll();
    }

    @Override
    public Fruit updateFruit(long id, Fruit fruit) {
        return fruitRepository.findById(id)
                .map(fruit1 -> {
                    fruit1.setName(fruit.getName());
                    fruit1.setPrice(fruit.getPrice());
                    return fruitRepository.save(fruit1);
                }).orElse( null);
    }

    @Override
    public String deleteFruit(long id) {
        fruitRepository.deleteById(id);
        return "Fruit Deleted Successfully";
    }
}
