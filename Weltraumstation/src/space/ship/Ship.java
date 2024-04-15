package space.ship;

import space.simulation.Vehicle;

public abstract class Ship extends Vehicle{
	
	private int defense;
	private int capacity;
	private String condition;
	private int level;
	
	public Ship (int defense, int capacity) {
		this.defense = defense;
		this.capacity = capacity;
		this.condition = "voll funktionsfähig";
		this.level = 1;
	}


}
