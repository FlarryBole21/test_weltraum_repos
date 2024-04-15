package space.resource;

public abstract class Resource implements Degradable{
	
	private String name;
	private int quality;
	private int miningDifficulty;
	private int miningTime;
	
	public Resource(String name, int quality, int miningDifficulty, int miningTime) {
		this.name=name;
		this.quality = quality;
		this.miningDifficulty = miningDifficulty;
		this.miningTime = miningTime;
	}

}
