package space.inventory.item.weapon;

public class ThunderstrikeCannon extends KineticWeapon{

	public ThunderstrikeCannon(int strength) {
		super(strength);
		super.setType("Donnerschlagkanone");
	}

	@Override
	public String getType() {
		return "Donnerschlag-Kanone";
	}

}
