package space.inventory.resource;

public class RawChicken extends RawFood{

	public RawChicken(int amount) {
		super(amount);
		super.setType("Rohes Hähnchen");
	}
	
	
	@Override
	public void eat() {
		
	}

}
