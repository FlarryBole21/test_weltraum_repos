package space.inventory.item.suit;

public class StellarExoSuit extends Suit{

	public StellarExoSuit(int defense) {
		super(defense);
		super.setType("Steller-Exo-Anzug");
	}

	@Override
	public void wear() {
		
	}

	@Override
	public void upgrade() {
		
	}

	@Override
	public String getType() {
		return "Astral-Exo-Anzug";
	}

}
