package space.inventory.item.weapon;

public class CloseInWeaponSystem extends PointDefenseSystem {

	public CloseInWeaponSystem(int strength) {
		super(strength);
	}

	@Override
	public String getType() {
		return "Close-In-Waffensystem";
	}

}
