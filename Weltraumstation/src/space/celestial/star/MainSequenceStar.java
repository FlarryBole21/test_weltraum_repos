package space.celestial.star;

public class MainSequenceStar extends Sun{

	public MainSequenceStar(String name, double mass, double radius, double temperature, double luminosity) {
		super(name, mass, radius, temperature, luminosity);
	}
	
	public MainSequenceStar() {
		super();
	}

	@Override
	public String getType() {
		return "Hauptsequenzstern";
	}

}
