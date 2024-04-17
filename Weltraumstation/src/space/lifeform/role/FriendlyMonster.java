package space.lifeform.role;

import java.util.LinkedList;

import space.inventory.Droppable;
import space.lifeform.Killable;
import space.lifeform.Monster;

public abstract class FriendlyMonster extends Monster implements Killable{
	
	private LinkedList<Droppable> drops;

	public FriendlyMonster(String name, int strength, int defense) {
		super(name, strength, defense);
	}

}
