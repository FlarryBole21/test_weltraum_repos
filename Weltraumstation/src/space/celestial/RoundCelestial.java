package space.celestial;

import java.util.LinkedList;

import space.Enterable;
import space.environment.atmosphere.Atmosphere;

public abstract class RoundCelestial extends CelestialObject implements Enterable{

	private static final long serialVersionUID = 1L;
	
	abstract public LinkedList<String> getInformation();
	
	abstract public Atmosphere getAtmosphere();
	
	abstract public String getName();

}
