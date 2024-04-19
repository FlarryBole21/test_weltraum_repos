package space.lifeform;

public class Snail extends KillableAnimal{

	public Snail(int strength, int defense) {
		super(strength, defense);
		super.setType("Schnecke");
	}


	@Override
	public void kill() {
		
	}

}
