package space.resource;

public abstract class Resource implements Collectable{
	
	private String name;
	private int quality;

	public Resource(String name, int quality) {
		this.name=name;
		this.quality = quality;
	}

}
