package space.inventory.item.weapon;

public class PlasmaClaws extends MeleeWeapon{

	public PlasmaClaws(int strength) {
		super(strength);
		super.setType("Plasma-Krallen");
	}

	@Override
	public String getType() {
		return "Plasma-Krallen";
	}

}
