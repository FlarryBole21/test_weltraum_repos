package space.buildable;

public abstract class Factory extends Building{
	

	private int level;
	
	public Factory() {
		this.level = 1;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public void demolition() {
		
	}

	@Override
	public void build() {
		
	}

	@Override
	public void upgrade() {
		// TODO Auto-generated method stub
		
	}

}
