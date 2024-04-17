package space.celestial.star;

public class RedGiant extends Sun{

	public RedGiant(String name, double mass, double radius, double temperature, double luminosity) {
		super(name, mass, radius, temperature, luminosity);
	}

	public RedGiant() {
		super();
	}
	
	@Override
	public String getType() {
		return "Roter Riese";
	}

}
