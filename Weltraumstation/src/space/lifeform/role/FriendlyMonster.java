package space.lifeform.role;

import space.lifeform.Killable;
import space.lifeform.Monster;

public abstract class FriendlyMonster extends Monster implements Killable{

	public FriendlyMonster(String name, int strength, int defense) {
		super(name, strength, defense);
	}

}
