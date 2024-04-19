package space.inventory.item.weapon;

public class PlasmaPulseBlaster extends EnergyRangeWeapon{

	public PlasmaPulseBlaster(int strength) {
		super(strength);
		super.setType("Plasmapuls-Blaster");
	}

	@Override
	public String getType() {
		return "Plasmapuls-Blaster";
	}

}
