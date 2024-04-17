package space.lifeform;

import space.Typeable;

public abstract class LifeformObject implements Typeable{
	
	private String name;
	private int strength;
	private int defense;
	private int level;
	private String type;
	
	public LifeformObject(String name, int strength, int defense) {
		this.name = name;
		this.strength = strength;
		this.defense = defense;
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

}
