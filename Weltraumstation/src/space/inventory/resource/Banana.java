package space.inventory.resource;

public class Banana extends Fruit{

	public Banana(String name, int quality) {
		super(name, quality);
	}

	@Override
	public void harvest() {
		
	}

	@Override
	public String getType() {
		return "Banane";
	}

}
