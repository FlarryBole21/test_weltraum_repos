package space;

import java.util.LinkedList;
import space.celestial.Planet;
import space.celestial.star.Sun;

public class SolarSystem {
	
	private String name;
	private LinkedList<Sun> suns;
	private LinkedList<Planet> planets;
	
	public SolarSystem(String name) {
		this.suns = new LinkedList<>();
		this.planets = new LinkedList<>();
	}

}
