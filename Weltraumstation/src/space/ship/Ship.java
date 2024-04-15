package space.ship;

import space.simulation.Buildable;

public abstract class Ship implements Buildable{
	
	private int strength;
	private int defense;
	private int capacity;
	
	public Ship(int strength, int defense, int capacity) {
		this.strength = strength;
		this.defense = defense;
		this.capacity = capacity;
	}
	
	

}
