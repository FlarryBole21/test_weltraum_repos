package space.inventory.resource;

import space.inventory.item.food.Eatable;

public abstract class RawFood extends Resource implements Eatable{

	private static final long serialVersionUID = 1L;

	public RawFood(int amount) {
		super(amount);
	}
	



}
