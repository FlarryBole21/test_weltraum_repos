package space.ship;

import space.simulation.Buildable;
import space.simulation.Demolitionable;
import space.simulation.Upgradable;

public abstract class Ship implements Buildable, Demolitionable, Upgradable{
	
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
