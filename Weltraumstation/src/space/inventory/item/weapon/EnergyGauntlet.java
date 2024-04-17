package space.inventory.item.weapon;

public class EnergyGauntlet extends EnergyMeleeWeapon{

	public EnergyGauntlet(int strength) {
		super(strength);
	}

	@Override
	public String getType() {
		return "Energie-Handschuhe";
	}

}
