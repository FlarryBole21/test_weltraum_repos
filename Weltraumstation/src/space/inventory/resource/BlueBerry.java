package space.inventory.resource;

public class BlueBerry extends Berry {

	private static final long serialVersionUID = 1L;


	public BlueBerry(int requiredLevel, int amount) {
		super(requiredLevel, amount);
		super.setType("Blaubeere");
	}
	

	@Override
	public void eat() {
		
		
	}

}
