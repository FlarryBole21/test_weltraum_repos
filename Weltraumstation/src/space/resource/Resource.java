package space.resource;

import space.simulation.Droppable;

public abstract class Resource implements Collectable, Droppable{
	
	private String name;
	private int quality;

	public Resource(String name, int quality) {
		this.name=name;
		this.quality = quality;
	}

}
