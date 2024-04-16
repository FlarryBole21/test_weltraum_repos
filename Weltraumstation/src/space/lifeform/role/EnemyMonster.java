package space.lifeform.role;

import java.util.LinkedList;

import space.inventory.Droppable;
import space.lifeform.Monster;

public class EnemyMonster extends Monster{
	
	private LinkedList<Droppable> drops;
	
	public EnemyMonster(String name, int strength, int defense) {
		super(name, strength, defense);
		this.drops = new LinkedList<>();
	}

}
