package com.example.carrentalproject.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.carrentalproject.dao.CarDao;
import com.example.carrentalproject.models.Car;
import com.example.carrentalproject.services.CarService;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	CarDao carDao;
	

	@Override
	public Car saveCar(Car car) {
		return carDao.saveCar(car);
	}

	@Override
	public Car updateCar(Long id, Car car) {
		return carDao.updateCar(id, car);		
	}

	@Override
	public Car getCar(Long id) {
		return carDao.getCar(id);
	}

	@Override
	public List<Car> getAllCars() {
		return carDao.getAllCars();
	}

	@Override
	public void deleteCar(Long id) {
		 carDao.deleteCar(id);
	}

}
