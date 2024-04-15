package space.weapon;

import space.item.Item;
import space.simulation.Upgradable;

public abstract class Weapon extends Item implements Upgradable{
	
	private int strength;
	private int level;
	
	public Weapon(int strength) {
		this.strength = strength;
		this.level = 1;
	}

	@Override
	public void use() {
		
	}

	@Override
	public void upgrade() {
		
	}
	
	

}
