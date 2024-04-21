package space.buildable.ship;

import java.util.LinkedList;

import space.buildable.Vehicle;

public abstract class Ship extends Vehicle{

	private static final long serialVersionUID = 1L;
	private int defense;
	private int health;
	private int capacity;
	private int level;
	
	public Ship (int defense, int health, int capacity) {
		this.defense = defense;
		this.health = health;
		this.capacity = capacity;
		this.level = 1;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
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
	
	@Override
	public void upgrade(Runnable setLevel) {
		setLevel.run();
	}
	
	public LinkedList<String>  getInformation() {
		LinkedList<String> information = new LinkedList<>();
		information.add("Verteidigung <" + defense+">");
		information.add("Lebenspunkte <" + health+">");
		information.add("Kapazität <" + capacity+">");
		information.add("Level <" + level+">");
		
		return information;
	}
	
	
	


}
