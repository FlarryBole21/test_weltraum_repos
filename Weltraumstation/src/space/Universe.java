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
	private LinkedList<String> planetdata;
	private LinkedList<String> sundata;
	
	public Universe(String name) {
		this.name = name;
		this.galaxies = new LinkedList<>();
		this.atmospheres = new LinkedList<>();
		addAtmospheres();
		
	}
	
	public LinkedList<String> getPlanetdata() {
		return planetdata;
	}

	public LinkedList<String> getSundata() {
		return sundata;
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


}
