package space.inventory.item.weapon;

public class PlasmaClaws extends MeleeWeapon{

	private static final long serialVersionUID = 1L;

	public PlasmaClaws(int strength) {
		super(strength);
		super.setType("Plasma-Krallen");
	}

	@Override
	public String getType() {
		return "Plasma-Krallen";
	}

}
