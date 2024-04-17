package space.inventory.resource;

public class RawChicken extends RawFood{

	public RawChicken(String name, int quality) {
		super(name, quality);
	}

	@Override
	public String getType() {
		return "Rohes Hähnchen";
	}

}
