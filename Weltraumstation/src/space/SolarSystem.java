package space;

import java.util.LinkedList;
import space.celestial.Planet;
import space.celestial.star.BlueGiant;
import space.celestial.star.MainSequenceStar;
import space.celestial.star.RedDwarf;
import space.celestial.star.RedGiant;
import space.celestial.star.Sun;
import space.celestial.star.SuperGiant;
import space.celestial.star.WhiteDwarf;
import space.environment.atmosphere.Atmosphere;

public class SolarSystem {
	
	private String name;
	private LinkedList<Sun> suns;
	private LinkedList<Planet> planets;
	private MainSequenceStar mainstar;

	public SolarSystem(String name) {
		this.name = name;
		this.suns = new LinkedList<>();
		this.planets = new LinkedList<>();
	}
	
	public MainSequenceStar getMainstar() {
		return mainstar;
	}

	public void setMainstar(MainSequenceStar mainstar) {
		this.mainstar = mainstar;
	}

	
	public String getName() {
		return this.name;
	}
	
	
	public Sun addSun(String name, double mass, double radius, double temperature, double luminosity, Sun suntype) {
		Sun sun = null;
		if(suntype instanceof MainSequenceStar) {
			sun = new MainSequenceStar(name, mass, radius, temperature, luminosity);
		}else if(suntype instanceof BlueGiant) {
			sun = new BlueGiant(name, mass, radius, temperature, luminosity);
		}else if(suntype instanceof WhiteDwarf) {
			sun = new WhiteDwarf(name, mass, radius, temperature, luminosity);
		}else if(suntype instanceof RedDwarf) {
			sun = new RedDwarf(name, mass, radius, temperature, luminosity);
		}else if(suntype instanceof RedGiant) {
			sun = new RedGiant(name, mass, radius, temperature, luminosity);
		}else if(suntype instanceof SuperGiant) {
			sun = new SuperGiant(name, mass, radius, temperature, luminosity);
		}
		suns.add(sun);
		return sun;
		
	}
	
	
	public Planet addPlanet(String name, double size, double mass, double radius,
			double gravity, Atmosphere atmosphere) {
		
		Planet planet = new Planet(name, size, mass, radius, gravity, atmosphere);
		planets.add(planet);
		return planet;
		
	}
	
	
	public LinkedList<Planet> getPlanets() {
		return planets;
	}
	
	public LinkedList<String> getPlanetNames() {
		LinkedList<String> names = new LinkedList<>();
		for (int i = 0; i < getPlanets().size(); i++) {
			names.add(getPlanets().get(i).getName());
		}
		return names;
	}
	
	
	
	public LinkedList<Sun> getSuns() {
		return suns;
	}
	
	public LinkedList<String> getSunNames() {
		LinkedList<String> names = new LinkedList<>();
		for (int i = 0; i < getSuns().size(); i++) {
			names.add(getSuns().get(i).getName());
		}
		return names;
	}

}
