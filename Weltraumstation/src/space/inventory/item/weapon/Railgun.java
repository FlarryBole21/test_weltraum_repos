package space.inventory.item.weapon;

public class Railgun extends EnergyRangeWeapon{

	public Railgun(int strength) {
		super(strength);
		super.setType("Schienenkanone");
	}

	@Override
	public String getType() {
		return "Schienenkanone";
	}

}
