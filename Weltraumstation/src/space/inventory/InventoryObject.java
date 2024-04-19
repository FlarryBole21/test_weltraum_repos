package space.inventory;

import java.io.Serializable;

import space.Typeable;

public abstract class InventoryObject implements Droppable, Useable, Collectable, Typeable, Serializable{
	
	private static final long serialVersionUID = 1L;
	private String type;
	
	@Override
	public String getType() {
		return this.type;
	}

	@Override
	public void setType(String type) {
		this.type = type;
		
	}
	
	
	@Override
	public void collect() {
		
	}

	@Override
	public void drop() {
		
	}
	

}
