package space.buildable.ship;

import space.buildable.Vehicle;

public abstract class Ship extends Vehicle{

	private static final long serialVersionUID = 1L;
	private int defense;
	private int capacity;
	private int level;
	
	public Ship (int defense, int capacity) {
		this.defense = defense;
		this.capacity = capacity;
		this.level = 1;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	
	


}
