package space.lifeform.role;

import space.lifeform.Human;

public class HumanNPC extends Human{

	public HumanNPC(String name, int strength, int defense) {
		super(name, strength, defense);
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Mensch-NPC";
	}

}
