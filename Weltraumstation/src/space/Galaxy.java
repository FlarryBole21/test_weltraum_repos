package space;

import java.util.LinkedList;

public class Galaxy {
	
	private String name;
	private LinkedList<SolarSystem> solarSystems;
	
	public Galaxy(String name) {
		this.name = name;
		this.solarSystems = new LinkedList<>();
	}
	
	public SolarSystem addSolarSystem(String name) {
		SolarSystem solarSystem = new SolarSystem(name);
		solarSystems.add(solarSystem);
		return solarSystem;
		
	}

}
