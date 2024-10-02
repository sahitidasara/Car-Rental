package com.example.carrentalproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.carrentalproject.models.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {
public Car findById(Long id);
public void deleteById(Long id);
}
