package space.inventory.item.weapon;

public class LaserSword extends EnergyMeleeWeapon{

	public LaserSword(int strength) {
		super(strength);
	}

	@Override
	public String getType() {
		return "Laser-Schwert";
	}

}
