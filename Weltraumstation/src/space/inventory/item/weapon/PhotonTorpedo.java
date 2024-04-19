package space.inventory.item.weapon;

public abstract class PhotonTorpedo extends Missile{

	private static final long serialVersionUID = 1L;

	public PhotonTorpedo(int strength) {
		super(strength);
		super.setType("Photonen-Torpedo");
	}

}
