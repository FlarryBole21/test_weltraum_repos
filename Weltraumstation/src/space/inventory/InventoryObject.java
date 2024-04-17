package space.inventory;

import space.Typeable;

public abstract class InventoryObject implements Droppable, Useable, Collectable, Typeable{
	
	private String type;
	
	@Override
	public String getType() {
		return this.type;
	}

	@Override
	public void setType(String type) {
		this.type = type;
		
	}

}
