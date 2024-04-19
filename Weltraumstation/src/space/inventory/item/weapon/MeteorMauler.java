package space.inventory.item.weapon;

public class MeteorMauler extends KineticWeapon{

	public MeteorMauler(int strength) {
		super(strength);
		super.setType("Meteor-Mauler");
	}

	@Override
	public String getType() {
		return "Meteor-Mauler";
	}

}
