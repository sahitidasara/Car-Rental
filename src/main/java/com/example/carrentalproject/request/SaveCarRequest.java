package com.example.carrentalproject.request;

public class SaveCarRequest {

	private String model;
	private String brand;
	private String regNo;
	private double pricePerDay;
	private boolean isAvailable;

	public SaveCarRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SaveCarRequest(String model, String brand, String regNo, double pricePerDay, boolean isAvailable) {
		super();
		this.model = model;
		this.brand = brand;
		this.regNo = regNo;
		this.pricePerDay = pricePerDay;
		this.isAvailable = isAvailable;
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

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
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

	@Override
	public String toString() {
		return "SaveCarRequest [model=" + model + ", brand=" + brand + ", regNo=" + regNo + ", pricePerDay="
				+ pricePerDay + ", isAvailable=" + isAvailable + "]";
	}

}
