package space.resource;

public class ExoticResource extends Resource{

	public ExoticResource(String name, int quality, int miningDifficulty, int miningTime) {
		super(name, quality, miningDifficulty, miningTime);
	}

	@Override
	public void degrade() {
		
	}

}
