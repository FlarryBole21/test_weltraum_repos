package space.lifeform;

public abstract class KillableAnimal extends Animal implements Killable{

	public KillableAnimal(String name, int strength, int defense) {
		super(name, strength, defense);
	}

}
