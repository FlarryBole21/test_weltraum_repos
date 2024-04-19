package space.inventory.item.weapon;

public class StarshockMissile extends Missile{

	public StarshockMissile(int strength) {
		super(strength);
		super.setType("Sternschockrakete");
	}

	@Override
	public String getType() {
		return "Sternschock-Rakete";
	}

}
