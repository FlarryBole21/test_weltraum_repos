package space.inventory.resource;

public abstract class MiningResource extends Resource implements Degradable{
	
	private int miningDifficulty;
	private int miningTime;

	public MiningResource(String name, String quality, int miningDifficulty, int miningTime) {
		super(name, quality);
		this.miningDifficulty = miningDifficulty;
		this.miningTime = miningTime;
	}
	

	@Override
	public void degrade() {
		
	}

}
