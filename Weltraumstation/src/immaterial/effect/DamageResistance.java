package immaterial.effect;

public class DamageResistance extends Buff{

	private String type;
	
	public DamageResistance() {
		super.setType("Schadensresistenz");
		
	}

	@Override
	public String getType() {
		return type;
	}
}
