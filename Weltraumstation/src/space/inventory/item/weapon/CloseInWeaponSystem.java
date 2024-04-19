package space.inventory.item.weapon;

public class CloseInWeaponSystem extends PointDefenseSystem {

	private static final long serialVersionUID = 1L;

	public CloseInWeaponSystem(int strength) {
		super(strength);
		super.setType("CloseIn-Waffensystem");
	}

	@Override
	public String getType() {
		return "Close-In-Waffensystem";
	}

}
