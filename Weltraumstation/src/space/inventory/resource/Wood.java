package space.inventory.resource;

public abstract class Wood extends Resource implements Degradable{
	
	private int requiredLevel;

	public Wood(int requiredLevel, int amount) {
		super(amount);
		this.requiredLevel = requiredLevel;
	}
	

	public int getRequiredLevel() {
		return requiredLevel;
	}


	@Override
	public void degrade() {
		
	}

}