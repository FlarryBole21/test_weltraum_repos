package space.buildable.ship;

public class CargoShip extends Ship{

	private static final long serialVersionUID = 1L;

	public CargoShip(int defense, int capacity) {
		super(defense, capacity);
		super.setType("Frachtschiff");
	}

	@Override
	public void build() {
		
	}

	@Override
	public void demolition() {
		
	}

	@Override
	public void upgrade() {
		
	}

	

}
