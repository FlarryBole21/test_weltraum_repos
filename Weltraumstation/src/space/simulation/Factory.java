package space.simulation;

public class Factory implements Buildable, Demolitionable {
	
	private String name;
	private int level;
	
	
	public Factory(String name) {
		this.name = name;
		this.level = 1;
		
	}

	@Override
	public void demolition() {
		
	}

	@Override
	public void build() {
		
	}

}
