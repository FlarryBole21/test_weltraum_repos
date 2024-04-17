package space.inventory.resource;

public abstract class Fruit extends RawFood implements Harvestable{

	public Fruit(String name, int quality) {
		super(name, quality);
	}

}
