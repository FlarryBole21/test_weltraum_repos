package space.inventory.item.weapon;

public class EnergyGauntlet extends EnergyMeleeWeapon{

	public EnergyGauntlet(int strength) {
		super(strength);
		super.setType("Energie-Handschuhe");
	
	}

	@Override
	public String getType() {
		return "Energie-Handschuhe";
	}

}
