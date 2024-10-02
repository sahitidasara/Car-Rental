package com.example.carrentalproject.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.carrentalproject.models.Car;

@Component
public interface CarDao {

	public Car saveCar(Car car);
	public Car updateCar(Long id, Car car);
	public Car getCar(Long id);
	public List<Car> getAllCars();
	public void deleteCar(Long id);
}
