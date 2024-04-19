package space.inventory.item.weapon;

public class PhotonPhaser extends EnergyRangeWeapon{

	public PhotonPhaser(int strength) {
		super(strength);
		super.setType("Photon-Phaser");
	}

	@Override
	public String getType() {
		return "Photonen-Phaser";
	}

}
