package space.role;

import java.util.LinkedList;

import space.lifeform.Human;
import space.resource.Collectable;
import space.simulation.Upgradable;

public class Player extends Human implements Upgradable{
	
	private LinkedList<Collectable> inventory;
	private int miningLevel;
	private int cookingLevel;
	private int craftingLevel;
	private int buildingLevel;
	
	public Player(String name, int strength, int defense) {
		super(name, strength, defense);
		this.inventory = new LinkedList<>();
		this.miningLevel = 1;
		this.cookingLevel = 1;
		this.craftingLevel = 1;
		this.buildingLevel = 1;
	}

	@Override
	public void upgrade() {
		
	}

}
