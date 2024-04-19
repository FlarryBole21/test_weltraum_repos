package space.inventory.item.suit;

public class GalacticGlideGear extends Suit{

	public GalacticGlideGear(int defense) {
		super(defense);
		super.setType("Galaktische Gleiterrüstung");
	}

	@Override
	public void wear() {
		
	}

	@Override
	public void upgrade() {
		
	}

	@Override
	public String getType() {
		return "Galaktische Gleiter-Rüstung";
	}

}
