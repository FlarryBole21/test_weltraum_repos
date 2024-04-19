package space.inventory.item.weapon;

public class LaserCannon extends EnergyRangeWeapon{

	public LaserCannon(int strength) {
		super(strength);
		super.setType("Laserkanone");
	}

	@Override
	public String getType() {
		return "Laser-Kanone";
	}

}
