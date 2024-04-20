package space.inventory.item.suit;

public class SpacewalkerSuit extends Suit {

	private static final long serialVersionUID = 1L;

	public SpacewalkerSuit(int defense) {
		super(defense);
		super.setType("Weltraumwandereranzug");
	}

	@Override
	public void wear() {
		
	}

	@Override
	public void craft() {
		
	}

	@Override
	public String getType() {
		return "Weltraumwanderer-Anzug";
	}

}
