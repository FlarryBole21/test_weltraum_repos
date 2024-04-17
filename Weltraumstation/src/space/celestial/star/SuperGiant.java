package space.celestial.star;

public class SuperGiant extends Sun{

	public SuperGiant(String name, double mass, double radius, double temperature, double luminosity) {
		super(name, mass, radius, temperature, luminosity);
	}
	
	public SuperGiant() {
		super();
	}


	@Override
	public String getType() {
		return "Superriese";
	}

}
