package space.inventory.resource;

import space.inventory.InventoryObject;

public abstract class Resource extends InventoryObject{
	
	private static final long serialVersionUID = 1L;
	private int amount;
	
	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public Resource(int amount) {
		this.amount = amount;
	}
	

	@Override
	public void use() {
		
	}

}
