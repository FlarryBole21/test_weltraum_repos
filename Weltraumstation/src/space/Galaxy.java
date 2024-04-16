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

	public String getName() {
		return name;
	}

	public LinkedList<SolarSystem> getSolarSystems() {
		return solarSystems;
	}
	
	public LinkedList<String> getSolarSystemsNames() {
		LinkedList<String> names = new LinkedList<>();
		for (int i = 0; i < getSolarSystems().size(); i++) {
			names.add(getSolarSystems().get(i).getName());
		}
		return names;
	}

	
	

}
