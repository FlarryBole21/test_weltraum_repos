package space.celestial.star;

public class RedDwarf extends Sun{

	public RedDwarf(String name, double mass, double radius, double temperature, double luminosity) {
		super(name, mass, radius, temperature, luminosity);
	}
	
	public RedDwarf() {
		super();
	}

	@Override
	public String getType() {
		return "Roter Zwerg";
	}

}
