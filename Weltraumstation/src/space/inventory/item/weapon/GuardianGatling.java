package space.inventory.item.weapon;

public class GuardianGatling extends PointDefenseSystem{

	public GuardianGatling(int strength) {
		super(strength);
	}

	@Override
	public String getType() {

		return "Wächter-Gatling";
	}

}
