package space.inventory.item.weapon;

public class NormalMissile extends Missile{

	public NormalMissile(int strength) {
		super(strength);
		super.setType("Normale Rakete");
	}

	@Override
	public String getType() {
		return "Normale Rakete";
	}

}
