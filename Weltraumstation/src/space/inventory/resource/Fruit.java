package space.inventory.resource;

public abstract class Fruit extends RawFood implements Harvestable{

	private int requiredLevel;
	
	public Fruit(int requiredLevel) {
		super();
	}
	
	public int getRequiredLevel() {
		return requiredLevel;
	}


	@Override
	public void harvest() {
		
	}

}
