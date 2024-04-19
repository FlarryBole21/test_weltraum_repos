package space.lifeform.role;

public class EnemySlime extends EnemyMonster{
	

	private static final long serialVersionUID = 1L;

	public EnemySlime(int strength, int defense) {
		super(strength, defense);
		super.setType("Feindlicher Schleim");
	}

	@Override
	public void kill() {
		
	}


}
