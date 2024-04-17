package space.celestial.star;

import java.util.LinkedList;

import space.celestial.CelestialObject;

public abstract class Star extends CelestialObject {
	
	private String name;
    private double mass; 
    private double radius; 
    private double temperature; 
    private double luminosity;
    
    public Star(String name, double mass, double radius, double temperature, double luminosity ) {
    	this.name=name;
    	this.mass=mass;
    	this.radius=radius;
    	this.temperature=temperature;
    	this.luminosity=luminosity;
    }
    
    
    public String getName() {
		return this.name;
	}
    
    
    public LinkedList<String> getInformation() {
		LinkedList<String> information = new LinkedList<>();
		information.add("Name: " + name);
		information.add("Masse: " + mass);
		information.add("Radius: " + radius);
		information.add("Temperatur: " + temperature + " Celsius");
		information.add("Helligkeit: " + luminosity);

		
		return information;
		
	}

}
