package space.resource;

public class MiningResource extends Resource implements Degradable{
	
	private int miningDifficulty;
	private int miningTime;

	public MiningResource(String name, int quality, int miningDifficulty, int miningTime) {
		super(name, quality);
		this.miningDifficulty = miningDifficulty;
		this.miningTime = miningTime;
	}

	@Override
	public void degrade() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void collect() {
		// TODO Auto-generated method stub
		
	}

}