package com.github.parkinglotsystem.mavenproject.models;

public class Slot {
	// Private instance variables
	private int slotNumber;
	private String slotType;
	private boolean isOccupied;
	private Vehicle vehicle;
	private Ticket slotTicket;
	
	// Create constructor for slots class
	public Slot(int slotNumber, String slotType) {
		this.slotNumber = slotNumber;
		this.slotType = slotType;
		this.isOccupied = false;
		this.vehicle = null;
		this.slotTicket = null;
	}
	
	// Create getters
	// No setters will be needed for this case
	
	// Return slot number
	public int getSlotNumber() {
		return slotNumber;
	}
	
	// Return slot type
	public String getSlotType() {
		return slotType;
	}
	
	// Return status: occupied or not occupied
	public boolean isOccupied() {
		return isOccupied;
	}
	
	// Set status: occupied or not
	public void setIsOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}
	
	// Set vehicle
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	// Get vehicle
	public Vehicle getVehicle() {
		return vehicle;
	}
	
	// Get ticket
	public Ticket getSlotTicket() {
		return slotTicket;
	}
	
	// Get ticket as string
	public String getSlotTicketAsString() {
		return slotTicket.toString();
	}
	
	// Set ticket
	public void setSlotTicket(Ticket slotTicket) {
		this.slotTicket = slotTicket;
	}
	
	public String toString() {
		return "Slot Number: " + slotNumber + ", Type: " + slotType;
	}
}
