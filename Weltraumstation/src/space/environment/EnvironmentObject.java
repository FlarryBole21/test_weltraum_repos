package space.environment;

import space.Typeable;

public abstract class EnvironmentObject implements Typeable{
	
	private String type;
	
	@Override
	public String getType() {
		return this.type;
	}

	@Override
	public void setType(String type) {
		this.type = type;
		
	}

}
