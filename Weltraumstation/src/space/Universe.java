package space;

import java.util.LinkedList;

import space.environment.atmosphere.Atmosphere;
import space.environment.atmosphere.NormalAtmosphere;
import space.environment.atmosphere.PollutedAtmosphere;
import space.environment.atmosphere.ToxicAtmosphere;

public class Universe {
	private String name;
	private LinkedList<Galaxy> galaxies;
	private LinkedList<Atmosphere> atmospheres;
	
	public Universe(String name) {
		this.name = name;
		this.galaxies = new LinkedList<>();
		addAtmospheres();
		
	}
	
	public Galaxy addGalaxy(String name) {
		Galaxy galaxy = new Galaxy(name);
		galaxies.add(galaxy);
		return galaxy;
		
	}
	
	private void addAtmospheres() {
		atmospheres.add(new NormalAtmosphere());
		atmospheres.add(new PollutedAtmosphere());
		atmospheres.add(new ToxicAtmosphere());
		
	}

}
