package space.lifeform;

public abstract class Lifeform implements Killable{
	
	private String name;
	private int strength;
	private int defense;
	private int level;
	
	public Lifeform(String name, int strength, int defense) {
		this.name = name;
		this.strength = strength;
		this.defense = defense;
		this.level = 1;
	}

}
