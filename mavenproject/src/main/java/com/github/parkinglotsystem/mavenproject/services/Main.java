package com.github.parkinglotsystem.mavenproject.services;

import java.util.Scanner;

import com.github.parkinglotsystem.mavenproject.models.ParkingLot;
import com.github.parkinglotsystem.mavenproject.models.Vehicle;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		boolean close = false;
		ParkingLot parkingLot = null;
		
		while (!close) {
			
			// Retrieving the appropriate command
			String cmd = in.next();
			
			if (cmd.equals("create_parking_lot")) {
				String lotId = in.next();
				int floorCount = in.nextInt();
				int slotCount = in.nextInt();
				
				parkingLot = new ParkingLot(lotId, floorCount, slotCount);
		
				System.out.println("Created parking lot with " + floorCount +
						" floors and " + slotCount + " slots per floor." + "\n");
			}
			
			else if (cmd.equals("park_vehicle")) {
				String type = in.next();
				String regNumber = in.next();
				String color = in.next();
				Vehicle vehicle = new Vehicle(type, regNumber, color);
				
				String output = parkingLot.parkVehicle(vehicle); 
				System.out.println(output);
				
			}
			
			else if (cmd.equals("unpark_vehicle")) {
				String ticketId = in.next();
				String output = parkingLot.unparkVehicle(ticketId);
				System.out.println(output);
			}
			
			else if (cmd.equals("display")) {
				String subCmd = in.next();
				
				if (subCmd.equals("free_count")) {
					String vehicleType = in.next();
					
					String output = parkingLot.freeCount(vehicleType);
					System.out.println(output);
				}
				
				else if (subCmd.equals("free_slots")) {
					String vehicleType = in.next();
					
					String output = parkingLot.freeSlot(vehicleType);
					System.out.println(output);
				}
				
				else if (subCmd.equals("occupied_slots")) {
					String vehicleType = in.next();
					
					String output = parkingLot.occupiedSlot(vehicleType);
					System.out.println(output);
				}
			}
			
			else if (cmd.equals("exit")) {
				close = true;
			}
			
			else {
				System.out.println("Error: command not found." + "\n");
			}	
		}
		
		in.close();
			
	}

}
