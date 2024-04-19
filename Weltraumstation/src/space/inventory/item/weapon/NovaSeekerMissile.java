package space.inventory.item.weapon;

public class NovaSeekerMissile extends Missile{

	private static final long serialVersionUID = 1L;

	public NovaSeekerMissile(int strength) {
		super(strength);
		super.setType("Nova-Sucher-Rakete");
	}

	@Override
	public String getType() {
		return "Nova-Sucher-Rakete";
	}

}
