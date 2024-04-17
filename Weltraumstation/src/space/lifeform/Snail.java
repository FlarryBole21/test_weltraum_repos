package space.lifeform;

public class Snail extends KillableAnimal{

	public Snail(String name, int strength, int defense) {
		super(name, strength, defense);
	}

	@Override
	public String getType() {
		return "Schnecke";
	}

	@Override
	public void kill() {
		
	}

}
