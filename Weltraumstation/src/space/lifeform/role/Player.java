package space.lifeform.role;

import java.util.LinkedList;

import space.Upgradable;
import space.inventory.Collectable;
import space.lifeform.Human;
import space.lifeform.Killable;

public class Player extends Human implements Upgradable, Killable{
	
	private LinkedList<Collectable> inventory;
	private int miningLevel;
	private int cookingLevel;
	private int craftingLevel;
	private int buildingLevel;
	
	public Player(String name, int strength, int defense) {
		super(name, strength, defense);
		super.setType("Spieler");
		this.inventory = new LinkedList<>();
		this.miningLevel = 1;
		this.cookingLevel = 1;
		this.craftingLevel = 1;
		this.buildingLevel = 1;
	}

	@Override
	public void upgrade() {
		
	}

	@Override
	public void kill() {
		
	}

	

}
