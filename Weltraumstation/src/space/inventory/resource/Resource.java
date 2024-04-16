package space.inventory.resource;

import space.inventory.InventoryObject;

public abstract class Resource extends InventoryObject{
	
	private String name;
	private int quality;

	public Resource(String name, int quality) {
		this.name=name;
		this.quality = quality;
	}

}
