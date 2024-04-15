package space.simulation;

import java.util.LinkedList;

import space.atmosphere.Atmosphere;
import space.lifeform.Lifeform;
import space.resource.Resource;
import space.terrain.Terrain;

public class Moon {
	
	private String name;
	private double size;
	private double mass;
	private double gravity;
	private boolean habitable;
	private LinkedList<Resource> resources;
	private LinkedList<Terrain> terrains;
	private LinkedList<Lifeform> lifeforms;
	private Atmosphere atmosphere;
	
	public Moon(String name) {
		
	}

}
