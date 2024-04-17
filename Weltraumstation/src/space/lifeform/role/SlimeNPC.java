package space.lifeform.role;

public class SlimeNPC extends MonsterNPC{

	public SlimeNPC(String name, int strength, int defense) {
		super(name, strength, defense);
	}

	@Override
	public String getType() {
		return "Schleim-NPC";
	}

}
