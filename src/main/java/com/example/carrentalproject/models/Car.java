package com.example.carrentalproject.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "cars")
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "model")
	@NotNull
	private String model;

	@Column(name = "brand")
	@NotNull
	private String brand;

	@Column(name = "reg_no")
	@NotNull
	private String regNo;

	@Column(name = "price_per_day")
	@NotNull
	private double pricePerDay;

	@Column(name = "is_available")
	@NotNull
	private boolean isAvailable;

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Car(Long id, @NotNull String model, @NotNull String brand, @NotNull double pricePerDay,
			@NotNull boolean isAvailable) {
		super();
		this.id = id;
		this.model = model;
		this.brand = brand;
		this.pricePerDay = pricePerDay;
		this.isAvailable = isAvailable;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", model=" + model + ", brand=" + brand + ", regNo=" + regNo + ", pricePerDay="
				+ pricePerDay + ", isAvailable=" + isAvailable + "]";
	}

}
