package space.inventory.item.suit;

public class AstroplateArmor extends Suit{

	public AstroplateArmor(int defense) {
		super(defense);
		super.setType("Astroplatten-Rüstung");
	}

	@Override
	public void wear() {
		
	}

	@Override
	public void upgrade() {
		
	}

	@Override
	public String getType() {
		return "Astroplatten-Rüstung";
	}

}
