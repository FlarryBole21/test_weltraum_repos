package space.celestial;

import java.util.LinkedList;

import space.buildable.SpaceStation;
import space.environment.atmosphere.Atmosphere;
import space.environment.atmosphere.NormalAtmosphere;
import space.environment.terrain.Terrain;
import space.inventory.resource.Resource;
import space.lifeform.LifeformObject;


public class Planet extends CelestialObject{
	
	private String name;
	private double size;
	private double mass;
	private double radius; 
	private double gravity;
	private boolean habitable;
	private LinkedList<Resource> resources;
	private LinkedList<Terrain> terrains;
	private LinkedList<Moon> moons;
	private LinkedList<SpaceStation> spaceStations;
	private LinkedList<LifeformObject> lifeforms;
	private Atmosphere atmosphere;
	
	
	public Planet(String name, double size, double mass, double radius,
			double gravity, boolean habitable, Atmosphere atmosphere) {
		this.name = name;
		this.size = size;
		this.mass = mass;
		this.radius = radius;
		this.gravity = gravity;
		this.habitable = habitable;
		this.atmosphere = atmosphere;
		this.resources = new LinkedList<>();
		this.moons = new LinkedList<>();
		this.spaceStations = new LinkedList<>();
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
	
	
	public void addLifeform(LifeformObject lifeform) {
		this.lifeforms.add(lifeform);
		
	}



}
