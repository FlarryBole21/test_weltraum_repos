package space.role;

import java.util.LinkedList;

import space.lifeform.Monster;
import space.simulation.Droppable;

public class EnemyMonster extends Monster{
	
	private LinkedList<Droppable> drops;
	
	public EnemyMonster(String name, int strength, int defense) {
		super(name, strength, defense);
		this.drops = new LinkedList<>();
	}

}
