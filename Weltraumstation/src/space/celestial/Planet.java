package space.celestial;

import java.util.LinkedList;
import space.buildable.SpaceStation;
import space.environment.atmosphere.Atmosphere;
import space.environment.terrain.Terrain;
import space.inventory.resource.Resource;
import space.lifeform.LifeformObject;


public class Planet extends CelestialObject{
	
	private String name;
	private double size;
	private double mass;
	private double radius; 
	private double gravity;
	private LinkedList<Resource> resources;
	private Terrain terrain;
	private LinkedList<Moon> moons;
	private LinkedList<SpaceStation> spaceStations;
	private LinkedList<LifeformObject> lifeforms;
	private Atmosphere atmosphere;
	
	
	public Planet(String name, double size, double mass, double gravity, Atmosphere atmosphere, Terrain terrain) {
		super.setType("Planet");
		this.name = name;
		this.size = size;
		this.mass = mass;
		this.radius = size/2;
		this.gravity = gravity;
		this.atmosphere = atmosphere;
		this.terrain = terrain;
		this.resources = new LinkedList<>();
		this.moons = new LinkedList<>();
		this.spaceStations = new LinkedList<>();
		this.lifeforms = new LinkedList<>();
		
	}
	
	public Atmosphere getAtmosphere() {
		return atmosphere;
	}
	
	public Terrain getTerrain() {
		return terrain;
	}

	public String getName() {
		return this.name;
	}
	
	public LinkedList<Moon> getMoons() {
		return moons;
	}
	
	public LinkedList<String> getMoonsNames() {
		LinkedList<String> names = new LinkedList<>();
		for (int i = 0; i < getMoons().size(); i++) {
			names.add(getMoons().get(i).getName());
		}
		return names;
	}
	
	
	public Moon addMoon(String name, double size, double mass, double gravity, Atmosphere atmosphere) {
		
		Moon moon = new Moon(name, size, mass, gravity, atmosphere);
		moons.add(moon);
		return moon;
	}
	
	public void addResource(Resource resource) {
		this.resources.add(resource);
		
	}

	public void addSpaceStation(SpaceStation spaceStation) {
		this.spaceStations.add(spaceStation);
		
	}
	
	public void addLifeform(LifeformObject lifeform) {
		this.lifeforms.add(lifeform);
		
	}
	
	public LinkedList<String> getMoonNames() {
		LinkedList<String> names = new LinkedList<>();
		for (int i = 0; i < getMoons().size(); i++) {
			names.add(getMoons().get(i).getName());
		}
		return names;
	}
	
	public LinkedList<String> getInformation() {
		LinkedList<String> information = new LinkedList<>();
		information.add("Name <" + name+">");
		information.add("Größe <" + size+">");
		information.add("Masse <" + mass+">");
		information.add("Radius <" + radius+">");
		information.add("Gravitation <" + gravity+">");
		information.add("Atmosphäre <" + atmosphere.getType()+">");
		information.add("Terrain <" + terrain.getType()+">");
		if(getMoonsNames().size() != 0) {
			information.add("Monde <" + getMoonsNames() +">");
		}else {
			information.add("Monde <Keine Monde vorhanden!>");
		}
		
		return information;
		
	}
	
	
}
