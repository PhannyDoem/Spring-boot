package com.student.service.impl;

import com.student.model.Car;
import com.student.repository.CarRepository;
import com.student.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public Car saveCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Optional<Car> getCarById(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car updateCar(long id, Car car) {
        return carRepository.findById(id)
                .map(car1 -> {
                    car1.setModel(car.getModel());
                    car1.setPrice(car.getPrice());
                    car1.setColor(car.getColor());
                    return carRepository.save(car1);
                }).orElse( null);
    }

    @Override
    public String deleteCar(long id) {
        carRepository.deleteById(id);
        return "Car Deleted Successfully";
    }
}
