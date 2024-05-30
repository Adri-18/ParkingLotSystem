package com.github.parkinglotsystem.mavenproject.models;

public class Vehicle {
	// The private instance variables
	private String type;
	private String regNumber;
	private String color;
	
	// Construct a vehicle with inputs
	public Vehicle(String type, String regNumber, String color) {
		this.type = type;
		this.regNumber = regNumber;
		this.color = color;
	}
	
	// Public getters
	// Vehicle properties will only be set once, no setters needed

	// Returns type of vehicle
	public String getType() {
		return type;
	}
	
	// Returns registration number of vehicle
	public String getRegNumber() {
		return regNumber;
	}
	
	// Returns color of vehicle
	public String getColor() {
		return color;
	}
	
	// toString()
	public String toString() {
		return type + regNumber + color;
	}
}
