package space.lifeform.role;

import space.lifeform.Human;
import space.lifeform.Killable;

public class EnemyHuman extends Human implements Killable{

	public EnemyHuman(String name, int strength, int defense) {
		super(name, strength, defense);
	}

	@Override
	public void kill() {

		
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Feindlicher Mensch";
	}

}
