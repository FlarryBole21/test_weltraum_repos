package space.inventory.item.weapon;

public class TitanTurret extends KineticWeapon{

	public TitanTurret(int strength) {
		super(strength);
		super.setType("Titan-Turret");
	}

	@Override
	public String getType() {
		return "Titan-Turret";
	}

}
