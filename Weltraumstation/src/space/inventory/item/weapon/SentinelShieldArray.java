package space.inventory.item.weapon;

public class SentinelShieldArray extends PointDefenseSystem{

	public SentinelShieldArray(int strength) {
		super(strength);
		super.setType("Wächterschildfeld");
	}

	@Override
	public String getType() {
		return "Wächterschildfeld";
	}

}
