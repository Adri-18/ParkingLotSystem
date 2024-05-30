package com.github.parkinglotsystem.mavenproject.models;

public class Floor {
	// The private instance variables
	private int floorNumber;
	private Slot[] slots;
	
	// Construct a floor instance
	public Floor(int floorNumber, int slotCount) {
		this.floorNumber = floorNumber;
		this.slots = new Slot[slotCount];
				
		// Create an array for slots
		for (int i = 0; i < slotCount; ++i) {
			if (i == 0) {
				slots[i] = new Slot(i + 1, "TRUCK");
			} else if (i == 1 || i == 2) {
				slots[i] = new Slot(i + 1, "BIKE");
			} else {
				slots[i] = new Slot(i + 1, "CAR");
			}
		}
	}
	
	// Public getters and setters
	// Floor number will only be set once, initially
	
	// Returns floor number
	public int getFloorNumber() {
		return floorNumber;
	}
	
	// To get slots array
	public Slot[] getSlots() {
		return slots;
	}
	
	// Accessing the certain slot number
	public Slot getSlot(int slotNumber) {
		return slots[slotNumber -1];
	}

	// toString
	public String toString() {
		return "Floor{" + floorNumber + "}"; 
	}

}
