package space.inventory.item.weapon;

public class XRayLaser extends EnergyRangeWeapon{

	public XRayLaser(int strength) {
		super(strength);
	}

	@Override
	public String getType() {
		return "XRay-Laser";
	}

}
