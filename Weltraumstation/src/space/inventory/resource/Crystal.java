package space.inventory.resource;

public class Crystal extends MiningResource {

	private static final long serialVersionUID = 1L;

	public Crystal(int requiredLevel, int amount) {
		super(requiredLevel, amount);
		super.setType("Kristall");
	}
	
	
	
}
