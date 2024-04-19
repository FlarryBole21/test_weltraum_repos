package immaterial.effect;

import java.io.Serializable;

import space.Typeable;

public abstract class Effect implements Typeable, Serializable{
	
	private static final long serialVersionUID = 1L;
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
