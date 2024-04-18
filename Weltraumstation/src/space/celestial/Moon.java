package space.celestial;

import java.util.LinkedList;

import space.celestial.star.MainSequenceStar;
import space.environment.atmosphere.Atmosphere;
import space.environment.terrain.MoonTerrain;
import space.environment.terrain.Terrain;
import space.inventory.resource.Resource;
import space.lifeform.LifeformObject;

public class Moon extends CelestialObject{
	
	private String name;
	private double size;
	private double mass;
	private double radius;
	private double gravity;
	private LinkedList<Resource> resources;
	private MoonTerrain moonTerrain;
	private LinkedList<LifeformObject> lifeforms;
	private Atmosphere atmosphere;
	private Planet planet;
	
	public Moon(String name, double size, double mass, double gravity, Atmosphere atmosphere) {
		super.setType("Mond");
		this.name=name;
		this.size=size;
		this.mass=mass;
		this.radius=size/2;
		this.gravity=gravity;
		this.atmosphere=atmosphere;
		this.resources= new LinkedList<>();
		//this.moonterrain = moonTerrain;
		this.lifeforms= new LinkedList<>();
	}

	
	public Planet getPlanet() {
		return planet;
	}

	public void setPlanet(Planet planet) {
		this.planet = planet;
	}
	
	
	public String getName() {
		return this.name;
	}
	
	public LinkedList<String> getInformation() {
		LinkedList<String> information = new LinkedList<>();
		information.add("Name <" + name+">");
		information.add("Größe <" + size+">");
		information.add("Masse <" + mass+">");
		information.add("Radius <" + radius+">");
		information.add("Gravitation <" + gravity+">");
		information.add("Atmosphäre <" + atmosphere.getType()+">");
		information.add("Zugehöriger Planet <" + planet.getName()+">");
		
		return information;
		
	}

}
