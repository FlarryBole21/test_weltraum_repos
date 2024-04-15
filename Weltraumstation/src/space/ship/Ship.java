package space.ship;

import space.simulation.Buildable;
import space.simulation.Killable;

public abstract class Ship implements Buildable, Killable{
	
	private int defense;
	private int capacity;
	
	public Ship (int defense, int capacity) {
		this.defense = defense;
		this.capacity = capacity;
	}
	
	

}
