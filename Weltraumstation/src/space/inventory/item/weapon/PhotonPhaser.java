package space.inventory.item.weapon;

public class PhotonPhaser extends EnergyRangeWeapon{

	private static final long serialVersionUID = 1L;

	public PhotonPhaser(int strength) {
		super(strength);
		super.setType("Photon-Phaser");
	}

	@Override
	public String getType() {
		return "Photonen-Phaser";
	}

}
