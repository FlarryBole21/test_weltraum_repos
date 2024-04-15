package space.resource;

public class Ore extends Resource{

	public Ore(String name, int quality, int miningDifficulty, int miningTime) {
		super(name, quality, miningDifficulty, miningTime);
	}

	@Override
	public void degrade() {
		
	}

}
