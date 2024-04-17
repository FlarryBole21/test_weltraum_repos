package space.lifeform;

public class Snail extends KillableAnimal{

	public Snail(String name, int strength, int defense) {
		super(name, strength, defense);
		super.setType("Schnecke");
	}


	@Override
	public void kill() {
		
	}

}
