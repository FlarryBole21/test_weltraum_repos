package space.inventory.item.weapon;

public class NovaSeekerMissile extends Missile{

	public NovaSeekerMissile(int strength) {
		super(strength);
		super.setType("Nova-Sucher-Rakete");
	}

	@Override
	public String getType() {
		return "Nova-Sucher-Rakete";
	}

}
