package com.student.controller;

import com.student.model.Fruit;
import com.student.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FruitController {
    @Autowired
    private FruitService fruitService;

    @GetMapping("/fruits")
    public ResponseEntity<List<Fruit>> getAllFruits(){
        List<Fruit> fruits = fruitService.getAllFruits();
        return new ResponseEntity<>(fruits, HttpStatus.OK);
    }

    @GetMapping("/fruit/{id}")
    public ResponseEntity<Fruit> getFruitById(@PathVariable Long id){
        Optional<Fruit> fruit = fruitService.getFruitById(id);
        return fruit.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/fruit")
    public ResponseEntity<Fruit> saveFruit(@RequestBody Fruit fruit){
        Fruit savedFruit = fruitService.saveFruit(fruit);
        return new ResponseEntity<>(savedFruit, HttpStatus.CREATED);
    }

    @PutMapping("/fruit/{id}")
    public ResponseEntity<Fruit> updateFruit(@PathVariable Long id, @RequestBody Fruit fruitDetails){
        Fruit updatedFruit = fruitService.updateFruit(id, fruitDetails);
        return updatedFruit != null ? new ResponseEntity<>(updatedFruit, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/fruit/{id}")
    public ResponseEntity<String> deleteFruit(@PathVariable Long id){
        String response = fruitService.deleteFruit(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
