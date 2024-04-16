package space;

import java.util.LinkedList;
import space.celestial.Planet;
import space.celestial.star.Sun;
import space.environment.atmosphere.Atmosphere;

public class SolarSystem {
	
	private String name;
	private LinkedList<Sun> suns;
	private LinkedList<Planet> planets;
	
	public SolarSystem(String name) {
		this.suns = new LinkedList<>();
		this.planets = new LinkedList<>();
	}
	
	public String getName() {
		return this.name;
	}
	
	
	public Sun addSun(String name, double mass, double radius, double temperature, double luminosity) {
		Sun sun = new Sun(name, mass, radius, temperature, luminosity);
		suns.add(sun);
		return sun;
		
	}
	
	
	public Planet addPlanet(String name, double size, double mass, double radius,
			double gravity, boolean habitable, Atmosphere atmosphere) {
		
		Planet planet = new Planet(name, size, mass, radius, gravity, habitable, atmosphere);
		planets.add(planet);
		return planet;
		
	}

}
