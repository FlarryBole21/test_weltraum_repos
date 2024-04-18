package space;

import java.util.LinkedList;

import space.celestial.star.Sun;
import space.environment.atmosphere.Atmosphere;
import space.environment.atmosphere.NormalAtmosphere;
import space.environment.atmosphere.PollutedAtmosphere;
import space.environment.atmosphere.ToxicAtmosphere;
import space.environment.terrain.Canyon;
import space.environment.terrain.Crater;
import space.environment.terrain.Desert;
import space.environment.terrain.Grassland;
import space.environment.terrain.Jungle;
import space.environment.terrain.Mountains;
import space.environment.terrain.NormalForest;
import space.environment.terrain.Savannah;
import space.environment.terrain.Swamp;
import space.environment.terrain.Terrain;
import space.environment.terrain.Tundra;
import space.environment.terrain.Volcano;
import space.celestial.star.MainSequenceStar;
import space.celestial.star.BlueGiant;
import space.celestial.star.RedDwarf;
import space.celestial.star.RedGiant;
import space.celestial.star.WhiteDwarf;
import space.celestial.star.SuperGiant;

public class Universe {
	
	private String name;
	private LinkedList<Galaxy> galaxies;
	private LinkedList<Atmosphere> atmospheres;
	private LinkedList<Terrain> terrains;
	private LinkedList<Sun> suns;
	private LinkedList<String> planetdata;
	private LinkedList<String> sundata;
	private LinkedList<String> moondata;
	
	public Universe(String name) {
		this.name = name;
		this.galaxies = new LinkedList<>();
		this.atmospheres = new LinkedList<>();
		this.suns = new LinkedList<>();
		this.terrains = new LinkedList<>();
		addAtmospheres();
		addTerrains();
		addSuns();
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public LinkedList<String> getPlanetdata() {
		return planetdata;
	}

	public LinkedList<String> getSundata() {
		return sundata;
	}
	
	public LinkedList<String> getMoondata() {
		return moondata;
	}

	public void setPlanetdata(LinkedList<String> planetdata) {
		LinkedList<String> cleanedList = new LinkedList<>();
	    for (String str : planetdata) {
	    	String cleanedString = str.replaceAll("\\s+", " "); 
	    	cleanedList.add(cleanedString);
	    }
	    this.planetdata = cleanedList;
	}

	public void setSundata(LinkedList<String> sundata) {
	    LinkedList<String> cleanedList = new LinkedList<>();
	    for (String str : sundata) {
	    	String cleanedString = str.replaceAll("\\s+", " "); 
	        cleanedList.add(cleanedString);
	    }
	    this.sundata = cleanedList;
	}
	
	
	public void setMoondata(LinkedList<String> moondata) {
	    LinkedList<String> cleanedList = new LinkedList<>();
	    for (String str : moondata) {
	    	String cleanedString = str.replaceAll("\\s+", " "); 
	        cleanedList.add(cleanedString);
	    }
	    this.moondata = cleanedList;
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

	public LinkedList<Atmosphere> getAtmospheres() {
		return atmospheres;
	}
	
	public LinkedList<Terrain> getTerrains() {
		return terrains;
	}
	
	
	private void addTerrains() {
		terrains.add(new Canyon());
		terrains.add(new Crater());
		terrains.add(new Desert());
		terrains.add(new Grassland());
		terrains.add(new Jungle());
		terrains.add(new Mountains());
		terrains.add(new NormalForest());
		terrains.add(new Savannah());
		terrains.add(new Swamp());
		terrains.add(new Tundra());
		terrains.add(new Volcano());
		
		
	}
	
	private void addSuns() {
		suns.add(new MainSequenceStar());
		suns.add(new BlueGiant());
		suns.add(new RedDwarf());
		suns.add(new RedGiant());
		suns.add(new WhiteDwarf());
		suns.add(new SuperGiant());
		
	}
	
	
	public LinkedList<Sun> getSuns() {
		return suns;
	}


}
