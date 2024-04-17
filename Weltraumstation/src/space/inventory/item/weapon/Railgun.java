package space.inventory.item.weapon;

public class Railgun extends EnergyRangeWeapon{

	public Railgun(int strength) {
		super(strength);
	}

	@Override
	public String getType() {
		return "Schienenkanone";
	}

}
