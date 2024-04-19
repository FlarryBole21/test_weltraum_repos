package space.inventory.item.weapon;

public class MeteorMauler extends KineticWeapon{

	private static final long serialVersionUID = 1L;

	public MeteorMauler(int strength) {
		super(strength);
		super.setType("Meteor-Mauler");
	}

	@Override
	public String getType() {
		return "Meteor-Mauler";
	}

}
