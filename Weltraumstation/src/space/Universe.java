package space;

import java.util.LinkedList;

public class Universe {
	private String name;
	private LinkedList<Galaxy> galaxies;
	
	public Universe(String name) {
		this.name = name;
		this.galaxies = new LinkedList<>();
	}
	
	public Galaxy addGalaxy(String name) {
		Galaxy galaxy = new Galaxy(name);
		galaxies.add(galaxy);
		return galaxy;
		
	}

}
