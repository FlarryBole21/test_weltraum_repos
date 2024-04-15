package space.role;

import java.util.LinkedList;

import space.lifeform.Monster;
import space.resource.Collectable;

public class Enemy extends Monster{
	
	private int strength;
	private int defense;
	private LinkedList<Collectable> inventory;
	
	public Enemy(String name) {
		super(name);
		this.strength = 10;
		this.defense = 10;
		this.inventory = new LinkedList<>();
	}

}
