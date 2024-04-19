package space.inventory.item.weapon;

public class CloseInWeaponSystem extends PointDefenseSystem {

	public CloseInWeaponSystem(int strength) {
		super(strength);
		super.setType("CloseIn-Waffensystem");
	}

	@Override
	public String getType() {
		return "Close-In-Waffensystem";
	}

}
