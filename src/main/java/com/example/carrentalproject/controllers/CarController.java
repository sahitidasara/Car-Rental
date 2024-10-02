package com.example.carrentalproject.controllers;

import java.util.List;

import org.apache.coyote.BadRequestException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.carrentalproject.models.Car;
import com.example.carrentalproject.request.SaveCarRequest;
import com.example.carrentalproject.request.UpdateCarRequest;
import com.example.carrentalproject.services.CarService;

import jakarta.validation.Valid;

@RestController
public class CarController {

	ModelMapper modelMapper = new ModelMapper();

	@Autowired
	CarService carService;

	@PostMapping("/car")
	public ResponseEntity<Car> addCar(@Valid @RequestBody SaveCarRequest carReq) {
		Car car = new Car();
		modelMapper.map(carReq, car);
		return new ResponseEntity<Car>(carService.saveCar(car), HttpStatus.CREATED);
	}

	@GetMapping("/car/{id}")
	public ResponseEntity<Car> getCar(@PathVariable("id") Long id) {
		return new ResponseEntity<Car>(carService.getCar(id), HttpStatus.OK);
	}

	@GetMapping("/cars/all")
	public ResponseEntity<List<Car>> getAllCars() {
		return ResponseEntity.ok(carService.getAllCars());
	}

	@PutMapping("/car/{id}")
	public ResponseEntity<Car> updateCar(@Valid @RequestBody UpdateCarRequest carReq, @PathVariable("id") Long id)
			throws BadRequestException {
		if (carService.getCar(id) == null) {
			throw new BadRequestException("Requested car not found");
		}
		Car car = new Car();
		modelMapper.map(carReq, car);
		return new ResponseEntity<Car>(carService.updateCar(id, car), HttpStatus.OK);
	}

	@DeleteMapping("/car/{id}")
	public ResponseEntity<String> deleteCar(@PathVariable("id") Long id) throws BadRequestException {
		if (carService.getCar(id) == null) {
			throw new BadRequestException("Requested car not found");
		}
		carService.deleteCar(id);
		return ResponseEntity.ok("Deleted car successfully");
	}

}
