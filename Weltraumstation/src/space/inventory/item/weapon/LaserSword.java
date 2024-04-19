package space.inventory.item.weapon;

public class LaserSword extends EnergyMeleeWeapon{

	private static final long serialVersionUID = 1L;

	public LaserSword(int strength) {
		super(strength);
		super.setType("Laserschwert");
	}

	@Override
	public String getType() {
		return "Laser-Schwert";
	}

}
