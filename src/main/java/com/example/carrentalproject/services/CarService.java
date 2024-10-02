package com.example.carrentalproject.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.carrentalproject.models.Car;

@Service
public interface CarService {
public Car saveCar(Car car);
public Car updateCar(Long id, Car car);	
public Car getCar(Long id);
public List<Car> getAllCars();
public void deleteCar(Long id);
}
