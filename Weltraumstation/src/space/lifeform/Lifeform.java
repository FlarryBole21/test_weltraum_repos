package space.lifeform;

import space.simulation.Killable;

public abstract class Lifeform implements Killable{
	
	private String name;
	
	public Lifeform(String name) {
		this.name = name;
	}

}
