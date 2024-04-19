package space.inventory.item.weapon;

public class NaniteWhip extends MeleeWeapon{

	private static final long serialVersionUID = 1L;

	public NaniteWhip(int strength) {
		super(strength);
		super.setType("Nanite-Peitsche");
	}

	@Override
	public String getType() {
		return "Nanite-Peitsche";
	}
	
	

}
