package space.inventory.item.weapon;

public class EnergyGauntlet extends EnergyMeleeWeapon{

	private static final long serialVersionUID = 1L;

	public EnergyGauntlet(int strength) {
		super(strength);
		super.setType("Energie-Handschuhe");
	
	}

	@Override
	public String getType() {
		return "Energie-Handschuhe";
	}

}
