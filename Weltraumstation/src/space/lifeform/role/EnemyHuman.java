package space.lifeform.role;

import java.util.LinkedList;

import space.inventory.Droppable;
import space.lifeform.Human;
import space.lifeform.Killable;

public class EnemyHuman extends Human implements Killable{
	

	private LinkedList<Droppable> drops;

	public EnemyHuman(String name, int strength, int defense) {
		super(name, strength, defense);
		super.setType("Feindlicher Mensch");
	}

	@Override
	public void kill() {

		
	}

	
	

}
