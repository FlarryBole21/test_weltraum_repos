package space.simulation;

public class Stock implements Buildable, Demolitionable, Upgradable{
	
	private String name;
	private int stockSize;
	private int level;
	
	public Stock(String name, int stockSize) {
		this.name = name;
		this.stockSize = stockSize;
		this.level=1;
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
