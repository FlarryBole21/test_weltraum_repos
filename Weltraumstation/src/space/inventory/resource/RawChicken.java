package space.inventory.resource;

public class RawChicken extends RawFood{

	private static final long serialVersionUID = 1L;


	public RawChicken(int amount) {
		super(amount);
		super.setType("Rohes Hähnchen");
	}
	
	
	@Override
	public void eat() {
		
	}

}
