package space.inventory.resource;

public class Plasma extends ExoticResource{

	public Plasma(String name, String quality, int miningDifficulty, int miningTime) {
		super(name, quality, miningDifficulty, miningTime);
		super.setType("Plasma");
	}
	

}
