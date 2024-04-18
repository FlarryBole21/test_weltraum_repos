package space.celestial.star;

public class BlueGiant extends Sun{

	public BlueGiant(String name, double mass, double radius, double temperature, double luminosity) {
		super(name, mass, radius, temperature, luminosity);
		super.setType("Blauer Riese");
	}
	
	public BlueGiant() {
		super.setType("Blauer Riese");
	}


}
