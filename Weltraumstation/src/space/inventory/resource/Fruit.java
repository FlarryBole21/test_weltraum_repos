package space.inventory.resource;

public abstract class Fruit extends RawFood implements Harvestable{

	public Fruit(String name, String quality) {
		super(name, quality);
	}
	
	@Override
	public void harvest() {
		
	}

}
