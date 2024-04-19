package immaterial.oracle;

import space.Typeable;

public abstract class Oracle implements Typeable{
	
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
