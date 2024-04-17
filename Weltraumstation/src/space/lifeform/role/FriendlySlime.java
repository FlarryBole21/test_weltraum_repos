package space.lifeform.role;

public class FriendlySlime extends FriendlyMonster{

	public FriendlySlime(String name, int strength, int defense) {
		super(name, strength, defense);
	}

	@Override
	public void kill() {
		
	}

	@Override
	public String getType() {
		return "Freundlicher Schleim";
	}

}
