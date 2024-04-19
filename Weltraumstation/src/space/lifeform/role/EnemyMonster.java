package space.lifeform.role;

import java.util.LinkedList;

import space.inventory.Droppable;
import space.lifeform.Killable;
import space.lifeform.Monster;

public abstract class EnemyMonster extends Monster implements Killable{
	
	private static final long serialVersionUID = 1L;
	private LinkedList<Droppable> drops;
	
	public EnemyMonster(int strength, int defense) {
		super(strength, defense);
		this.drops = new LinkedList<>();
	}

}
