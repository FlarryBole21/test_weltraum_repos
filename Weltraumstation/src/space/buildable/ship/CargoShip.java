package space.buildable.ship;

public class CargoShip extends Ship{

	private static final long serialVersionUID = 1L;

	public CargoShip(int health, int capacity) {
		super(health, capacity);
		super.setType("Frachtschiff");
	}

	@Override
	public void build() {
		
	}

	@Override
	public void demolition() {
		
	}



}
