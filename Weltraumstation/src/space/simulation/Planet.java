package space.simulation;

import java.util.LinkedList;
import space.atmosphere.Atmosphere;
import space.atmosphere.NormalAtmosphere;
import space.lifeform.Lifeform;
import space.resource.Resource;
import space.terrain.Terrain;


public class Planet {
	
	private String name;
	private double size;
	private double mass;
	private double gravity;
	private boolean habitable;
	private LinkedList<Resource> resources;
	private LinkedList<Terrain> terrains;
	private LinkedList<Lifeform> lifeforms;
	private Atmosphere atmosphere;
	
	
	public Planet(String name, double size, double mass, 
			double gravity, boolean habitable, Atmosphere atmosphere) {
		this.name = name;
		this.size = size;
		this.mass = mass;
		this.gravity = gravity;
		this.habitable = habitable;
		this.atmosphere = atmosphere;
		this.resources = new LinkedList<>();
		this.terrains = new LinkedList<>();
		this.lifeforms = new LinkedList<>();
		
	}
	
	public Planet(String name, double size, double mass) {
		this.name = name;
		this.size = size;
		this.mass = mass;
		this.gravity = 9.8;
		this.habitable = true;
		this.atmosphere = new NormalAtmosphere();
		this.resources = new LinkedList<>();
		this.terrains = new LinkedList<>();
		this.lifeforms = new LinkedList<>();
		
	}
	
	
	public void addResource(Resource resource) {
		this.resources.add(resource);
		
	}
	
	public void addTerrain(Terrain terrain) {
		this.terrains.add(terrain);
		
	}
	
	
	public void addLifeform(Lifeform lifeform) {
		this.lifeforms.add(lifeform);
		
	}



}
