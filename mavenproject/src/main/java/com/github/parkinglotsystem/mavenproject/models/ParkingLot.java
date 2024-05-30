package com.github.parkinglotsystem.mavenproject.models;

import java.util.ArrayList;

public class ParkingLot {
	// Creating private instance variables
	private String id;
	private Floor[] floors;
	private int floorCount;
	private int slotCount;
	
	// Construct a parking lot instance
	public ParkingLot(String id, int floorCount, int slotCount) {
		this.id = id;
		this.floorCount = floorCount;
		this.slotCount = slotCount;
		this.floors = new Floor[floorCount];
		
		// Create an array of floors
		for (int i = 0; i < floorCount; ++i) {
			floors[i] = new Floor(i + 1, slotCount);
		}
	}
	
	// Create getters and setters
	// Id will only be set once and therefore not needing of a setter
	
	// Return id of parking lot
	public String getId() {
		return id; 
	} 
	
	// Return floor numbers of parking lot
	public int getFloorCount() {
		return floorCount;
	}
	
	// Return number of slots per parking floor
	public int getSlotCount() {
		return slotCount;
	}
	
	// To access the certain floor number
	public Floor getFloor(int floorNumber) {
		return floors[floorNumber -1];
	}
	
	// To get floors array
	public Floor[] getFloors() {
		return floors;
	}
	
	// Method to park vehicles
	public String parkVehicle(Vehicle vehicle) {
		for (Floor floor : floors) {
			for (Slot slot : floor.getSlots()) {
				if (!slot.isOccupied() && 
						slot.getSlotType().equalsIgnoreCase(vehicle.getType())) {
					
					slot.setIsOccupied(true);
					slot.setVehicle(vehicle);
					
					Ticket ticket = new Ticket(floor.getFloorNumber(), slot.getSlotNumber());
					slot.setSlotTicket(ticket);
					
					return "Parked vehicle. Ticket ID: " + ticket + "\n";
				}
			}
		}
		return "Parking Lot Full" + "\n";
	}
	
	// Method to un-park vehicles
	public String unparkVehicle(String ticket) {
		for (Floor floor : floors) {
			for (Slot slot : floor.getSlots()) {
				if (slot.getSlotTicket() != null && 
						slot.getSlotTicketAsString().equalsIgnoreCase(ticket)) {
					
					String regNumber = slot.getVehicle().getRegNumber();
					String color = slot.getVehicle().getColor();
					
					slot.setIsOccupied(false);
					slot.setVehicle(null);
					slot.setSlotTicket(null);
					
					return "Unparked vehicle with Registration Number: " + regNumber + " and Color: " + color + "\n";

				}
			}
		}
		return "Invalid Ticket" + "\n";
	}
	
	// Method to find free count of a certain vehicle type
	public String freeCount(String vehicleType) {
		StringBuilder output = new StringBuilder();
		for (Floor floor : floors) {
			int count = 0;
			for (Slot slot : floor.getSlots()) {
				if (!slot.isOccupied() && slot.getSlotType().equalsIgnoreCase(vehicleType)) {
					count++;
				}
			}
			
			output.append("No. of free slots for ")
			.append(vehicleType)
			.append(" on Floor ")
			.append(floor.getFloorNumber())
			.append(": ")
			.append(count)
			.append("\n");
			   
		}
		return output.toString();
	}
	
	// Method to find free slots of a certain vehicle type
	public String freeSlot(String vehicleType) {
		StringBuilder output = new StringBuilder();
		
		for (Floor floor : floors) {
			ArrayList<Integer> list = new ArrayList<>();
			
			for (Slot slot : floor.getSlots()) {
				if (!slot.isOccupied() && slot.getSlotType().equalsIgnoreCase(vehicleType)) {
					list.add(slot.getSlotNumber());
				}
			}
			
			StringBuilder concatenatedInteger = new StringBuilder();
			
			for (int i = 0; i < list.size(); i++) {
				int slotNumber = list.get(i);
				
				if (i == list.size() - 1) {
					concatenatedInteger.append(slotNumber);
				} else {
					concatenatedInteger.append(slotNumber).append(", ");
				}		
			}
			
			output.append("Free slots for ")
			.append(vehicleType)
			.append(" on Floor ")
			.append(floor.getFloorNumber())
			.append(": ")
			.append(concatenatedInteger)
			.append("\n");
		}
		return output.toString();
	}
	
	// Method to find occupied slots of a certain vehicle type
	public String occupiedSlot(String vehicleType) {
		StringBuilder output = new StringBuilder();
		
		for (Floor floor : floors) {
			ArrayList<Integer> list = new ArrayList<>();
			
			for (Slot slot : floor.getSlots()) {
				if (slot.isOccupied() && slot.getSlotType().equalsIgnoreCase(vehicleType)) {
					list.add(slot.getSlotNumber());
				}
			}
			
			StringBuilder concatenatedInteger = new StringBuilder();
			
			for (int i = 0; i < list.size(); i++) {
				int slotNumber = list.get(i);
				
				if (i == list.size() - 1) {
					concatenatedInteger.append(slotNumber);
				} else {
					concatenatedInteger.append(slotNumber).append(", ");
				}
			}
			
			output.append("Occupied slots for ")
			.append(vehicleType)
			.append(floor.getFloorNumber())
			.append(": ")
			.append(concatenatedInteger)
			.append("\n");
		}
		return output.toString();
	}
}

