package space.inventory.item.weapon;

public class SentinelShieldArray extends PointDefenseSystem{

	public SentinelShieldArray(int strength) {
		super(strength);
	}

	@Override
	public String getType() {
		return "Wächterschildfeld";
	}

}
