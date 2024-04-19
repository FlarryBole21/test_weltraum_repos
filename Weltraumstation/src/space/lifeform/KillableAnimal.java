package space.lifeform;

import java.util.LinkedList;

import space.inventory.Droppable;

public abstract class KillableAnimal extends Animal implements Killable{
	
	private LinkedList<Droppable> drops;

	public KillableAnimal(int strength, int defense) {
		super(strength, defense);
	}

}
