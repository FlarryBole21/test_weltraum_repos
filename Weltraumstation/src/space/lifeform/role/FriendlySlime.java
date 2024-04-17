package space.lifeform.role;

public class FriendlySlime extends FriendlyMonster{


	public FriendlySlime(String name, int strength, int defense) {
		super(name, strength, defense);
		super.setType("Freundlicher Schleim");
	}

	@Override
	public void kill() {
		
	}


}
