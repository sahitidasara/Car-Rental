package com.example.carrentalproject.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.carrentalproject.dao.CarDao;
import com.example.carrentalproject.models.Car;
import com.example.carrentalproject.repository.CarRepository;

@Component
public class CarDaoImpl implements CarDao {

	@Autowired
	CarRepository carRepository;

	@Override
	public Car saveCar(Car car) {
		return carRepository.save(car);
	}

	@Override
	public Car updateCar(Long id, Car car) {
		Car carRes = carRepository.findById(id);
		carRes.setAvailable(car.isAvailable());
		return carRepository.save(carRes);
	}

	@Override
	public Car getCar(Long id) {
		return carRepository.findById(id);
	}

	@Override
	public List<Car> getAllCars() {
		return carRepository.findAll();
	}

	@Override
	public void deleteCar(Long id) {
		carRepository.deleteById(id);
	}

}
