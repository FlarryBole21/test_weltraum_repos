package space.inventory.item.weapon;

public class PhotonPhaser extends EnergyRangeWeapon{

	public PhotonPhaser(int strength) {
		super(strength);
	}

	@Override
	public String getType() {
		return "Photonen-Phaser";
	}

}
