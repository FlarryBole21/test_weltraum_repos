package space.inventory.item.suit;

public class StellarExoSuit extends Suit{

	private static final long serialVersionUID = 1L;

	public StellarExoSuit(int defense) {
		super(defense);
		super.setType("Steller-Exo-Anzug");
	}

	@Override
	public void wear() {
		
	}

	@Override
	public String getType() {
		return "Astral-Exo-Anzug";
	}

}
