package space.simulation;

public class SpaceStation extends Building{
	
	private String name;
	private int capacity;
	private int level;
	
	public SpaceStation(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
		this.level = 1;
	}

	@Override
	public void demolition() {
	
	}

	@Override
	public void build() {
		
	}

	@Override
	public void upgrade() {
		
	}

}
