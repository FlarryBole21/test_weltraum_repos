package immaterial.effect;

import space.Typeable;

public abstract class Effect implements Typeable{
	
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
