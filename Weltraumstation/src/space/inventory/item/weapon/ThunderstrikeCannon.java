package space.inventory.item.weapon;

public class ThunderstrikeCannon extends KineticWeapon{

	public ThunderstrikeCannon(int strength) {
		super(strength);
	}

	@Override
	public String getType() {
		return "Donnerschlag-Kanone";
	}

}
