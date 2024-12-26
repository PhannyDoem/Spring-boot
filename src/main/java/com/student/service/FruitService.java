package com.student.service;

import com.student.model.Fruit;

import java.util.List;
import java.util.Optional;

public interface FruitService {
    Fruit saveFruit(Fruit fruit);

    Optional<Fruit> getFruitById(Long id);

    List<Fruit> getAllFruits();

    Fruit updateFruit(long id, Fruit fruit);

    String deleteFruit(long id);
}
