package space.inventory.resource;

public class BlueBerry extends Berry {

	public BlueBerry(String name, int quality) {
		super(name, quality);
	}

	@Override
	public void harvest() {
		
	}

	@Override
	public String getType() {
		return "Blaubeere";
	}

}
