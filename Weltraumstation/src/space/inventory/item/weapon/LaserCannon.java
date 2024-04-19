package space.inventory.item.weapon;

public class LaserCannon extends EnergyRangeWeapon{

	private static final long serialVersionUID = 1L;

	public LaserCannon(int strength) {
		super(strength);
		super.setType("Laserkanone");
	}

	@Override
	public String getType() {
		return "Laser-Kanone";
	}

}
