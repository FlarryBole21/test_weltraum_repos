package space.lifeform;

import space.Typeable;

public abstract class LifeformObject implements Typeable{
	
	private int strength;
	private int health;
	private int level;
	private String type;
	
	public LifeformObject(int strength, int health) {
		this.strength = strength;
		this.health = health;
		this.level = 1;
	}
	
	@Override
	public String getType() {
		return this.type;
	}

	@Override
	public void setType(String type) {
		this.type = type;
		
	}
	
	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}


}
