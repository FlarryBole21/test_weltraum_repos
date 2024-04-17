package space.celestial.star;

public class BlueGiant extends Sun{

	public BlueGiant(String name, double mass, double radius, double temperature, double luminosity) {
		super(name, mass, radius, temperature, luminosity);
	}
	
	public BlueGiant() {
		super();
	}

	@Override
	public String getType() {	
		return "Blauer Riese";
	}

}
