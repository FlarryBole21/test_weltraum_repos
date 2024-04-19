package space.inventory.item.weapon;

public class Coilgun extends KineticWeapon{

	public Coilgun(int strength) {
		super(strength);
		super.setType("Spulenkanone");
	}

	@Override
	public String getType() {
		return "Spulenkanone";
	}

}
