package space.inventory.item.suit;

public class AstroplateArmor extends Suit{

	private static final long serialVersionUID = 1L;

	public AstroplateArmor(int defense) {
		super(defense);
		super.setType("Astroplatten-Rüstung");
	}

	@Override
	public void wear() {
		
	}

	@Override
	public String getType() {
		return "Astroplatten-Rüstung";
	}

}
