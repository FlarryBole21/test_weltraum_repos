package space.buildable.ship;

public class ColonyShip extends Ship{

	private static final long serialVersionUID = 1L;

	public ColonyShip(int health, int capacity) {
		super(health, capacity);
		super.setType("Kolonieschiff");
		
	}

	@Override
	public void build() {
		
	}

	@Override
	public void demolition() {
		
	}

	
}
