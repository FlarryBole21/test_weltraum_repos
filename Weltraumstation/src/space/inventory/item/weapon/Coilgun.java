package space.inventory.item.weapon;

public class Coilgun extends KineticWeapon{

	private static final long serialVersionUID = 1L;

	public Coilgun(int strength) {
		super(strength);
		super.setType("Spulenkanone");
	}

	@Override
	public String getType() {
		return "Spulenkanone";
	}

}
