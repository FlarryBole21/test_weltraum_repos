package space.celestial;

import java.util.LinkedList;

import space.environment.atmosphere.Atmosphere;
import space.environment.terrain.Terrain;
import space.inventory.resource.Resource;
import space.lifeform.LifeformObject;

public class Moon extends CelestialObject{
	
	private String name;
	private double size;
	private double mass;
	private double gravity;
	private LinkedList<Resource> resources;
	private LinkedList<Terrain> terrains;
	private LinkedList<LifeformObject> lifeforms;
	private Atmosphere atmosphere;
	
	public Moon(String name, double size, double mass, double radius,
			double gravity, Atmosphere atmosphere) {
		
	}

	@Override
	public String getType() {
		return "Mond";
	}

}
