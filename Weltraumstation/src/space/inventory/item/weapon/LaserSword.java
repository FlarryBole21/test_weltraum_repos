package space.inventory.item.weapon;

public class LaserSword extends EnergyMeleeWeapon{

	public LaserSword(int strength) {
		super(strength);
		super.setType("Laserschwert");
	}

	@Override
	public String getType() {
		return "Laser-Schwert";
	}

}
