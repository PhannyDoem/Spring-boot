package com.student.controller;


import com.student.model.Car;
import com.student.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CarController {
    @Autowired
    private CarService carService;


    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getAllCars(){
        List<Car> cars = carService.getAllCars();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping("/car/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id){
        Optional<Car> car = carService.getCarById(id);
        return car.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/car")
    public ResponseEntity<Car> saveCar(@RequestBody Car car){
        Car savedCar = carService.saveCar(car);
        return new ResponseEntity<>(savedCar, HttpStatus.CREATED);
    }
    @PutMapping("/car/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable long id, @RequestBody Car carDetails){
        Car updatedCar = carService.updateCar(id, carDetails);
        return updatedCar != null ? new ResponseEntity<>(updatedCar, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/car/{id}")
    public ResponseEntity<String> deleteCar(@PathVariable Long id){
        String response = carService.deleteCar(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
