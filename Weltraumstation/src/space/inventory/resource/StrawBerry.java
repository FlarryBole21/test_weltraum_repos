package space.inventory.resource;

public class StrawBerry extends Berry{

	public StrawBerry(String name, int quality) {
		super(name, quality);
	}

	@Override
	public void harvest() {
		
	}

	@Override
	public String getType() {
		return "Erdbeere";
	}

}
