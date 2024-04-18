package space.inventory.resource;

import space.inventory.InventoryObject;

public abstract class Resource extends InventoryObject{
	
	private String name;
	private String quality;

	public Resource(String name, String quality) {
		this.name=name;
		this.quality = quality;
	}
	

	@Override
	public void use() {
		
	}

}
