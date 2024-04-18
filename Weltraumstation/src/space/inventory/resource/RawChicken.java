package space.inventory.resource;

public class RawChicken extends RawFood{

	public RawChicken(String name, String quality) {
		super(name, quality);
		super.setType("Rohes Hähnchen");
	}
	
	
	@Override
	public void eat() {
		
	}

}
