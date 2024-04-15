package space.role;

import java.util.LinkedList;

import space.lifeform.Human;
import space.resource.Collectable;

public class Player extends Human{
	
	private int strength;
	private int defense;
	private LinkedList<Collectable> inventory;
	
	public Player(String name) {
		super(name);
		this.strength = 10;
		this.defense = 10;
		this.inventory = new LinkedList<>();
	}

}
