package space.buildable.ship;

import space.buildable.Vehicle;

public abstract class Ship extends Vehicle{
	
	private int defense;
	private int capacity;
	private int level;
	
	public Ship (int defense, int capacity) {
		this.defense = defense;
		this.capacity = capacity;
		this.level = 1;
	}


}
