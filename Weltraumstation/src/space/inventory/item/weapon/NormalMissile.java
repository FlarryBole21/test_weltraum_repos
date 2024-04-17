package space.inventory.item.weapon;

public class NormalMissile extends Missile{

	public NormalMissile(int strength) {
		super(strength);
	}

	@Override
	public String getType() {
		return "Normale Rakete";
	}

}
