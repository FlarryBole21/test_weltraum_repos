package space.inventory.resource;

import space.inventory.Collectable;
import space.inventory.Droppable;
import space.inventory.Useable;

public abstract class Resource implements Collectable, Droppable, Useable{
	
	private String name;
	private int quality;

	public Resource(String name, int quality) {
		this.name=name;
		this.quality = quality;
	}

}
