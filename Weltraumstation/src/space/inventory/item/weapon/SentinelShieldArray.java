package space.inventory.item.weapon;

public class SentinelShieldArray extends PointDefenseSystem{

	private static final long serialVersionUID = 1L;

	public SentinelShieldArray(int strength) {
		super(strength);
		super.setType("Wächterschildfeld");
	}

	@Override
	public String getType() {
		return "Wächterschildfeld";
	}

}
