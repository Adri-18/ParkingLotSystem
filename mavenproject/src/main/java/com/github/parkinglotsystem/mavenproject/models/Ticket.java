package com.github.parkinglotsystem.mavenproject.models;

public class Ticket {
	// CONSTANT
	public static final String FIXED_LOT_ID = "PR1234";
	
	// Create private instances variable
	private String lotId;
	private int floorNumber;
	private int slotNumber;
	
	// Create constructor
	public Ticket(int floorNumber, int slotNumber) {
		this.lotId = FIXED_LOT_ID;
		this.floorNumber = floorNumber;
		this.slotNumber = slotNumber;
	}
	
	// No setter for id, as it is set once at initialization
	// Return floor number on the ticket
	public int getFloorNumber() {
		return floorNumber;
	}
	
	// Return slot number on the ticket
	public int getSlotNumber() {
		return slotNumber;
	}
	
	// Return lot id on the ticket
	public String getLotId() {
		return lotId;
	}
	
	// Create toString()
	public String toString() {
		return lotId + "_" + floorNumber + "_" + slotNumber;
	}

}

