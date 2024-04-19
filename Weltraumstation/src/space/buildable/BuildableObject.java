package space.buildable;

import space.Typeable;
import space.Upgradable;

public abstract class BuildableObject implements Buildable, Demolitionable, Upgradable, Typeable{
	
	private String type;
	
	@Override
	public String getType() {
		return type;
	}
	
	
	@Override
	public void setType(String type) {
		this.type=type;
		
	}

}
