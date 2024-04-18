package space.inventory.resource;

public class Banana extends Fruit{

	public Banana(String name, String quality) {
		super(name, quality);
		super.setType("Banane");
	}
	
	@Override
	public void eat() {
		
	}


}
