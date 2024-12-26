package com.student.service;

import com.student.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {
    Car saveCar(Car car);

    Optional<Car> getCarById(Long id);

    List<Car> getAllCars();

    Car updateCar(long id, Car car);

    String deleteCar(long id);

}
