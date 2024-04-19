package space.inventory.item.weapon;

public class XRayLaser extends EnergyRangeWeapon{

	private static final long serialVersionUID = 1L;

	public XRayLaser(int strength) {
		super(strength);
		super.setType("XRay-Laser");
	}

	@Override
	public String getType() {
		return "XRay-Laser";
	}

}
