package space.inventory.item.food;

public class CookedChicken extends CookedFood  {
	
	public CookedChicken() {
		super.setType("Gekochtes Hähnchen");
	}

	@Override
	public void eat() {
		
	}

	@Override
	public String getType() {
		return "Gekochtes Hähnchen";
	}

}
