package space.inventory.resource;

public abstract class Fruit extends RawFood implements Harvestable{

	private int requiredLevel;
	
	public Fruit(int requiredLevel, int amount) {
		super(amount);
	}
	
	public int getRequiredLevel() {
		return requiredLevel;
	}


	@Override
	public void harvest() {
		
	}

}
