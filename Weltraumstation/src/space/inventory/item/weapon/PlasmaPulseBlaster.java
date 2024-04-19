package space.inventory.item.weapon;

public class PlasmaPulseBlaster extends EnergyRangeWeapon{

	private static final long serialVersionUID = 1L;

	public PlasmaPulseBlaster(int strength) {
		super(strength);
		super.setType("Plasmapuls-Blaster");
	}

	@Override
	public String getType() {
		return "Plasmapuls-Blaster";
	}

}
