package space.celestial.star;

public class WhiteDwarf extends Sun{

	public WhiteDwarf(String name, double mass, double radius, double temperature, double luminosity) {
		super(name, mass, radius, temperature, luminosity);
		super.setType("Weißer Zwerg");
	}
	
	public WhiteDwarf() {
		super.setType("Weißer Zwerg");
	}


}
