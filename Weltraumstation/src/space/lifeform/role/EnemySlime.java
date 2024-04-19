package space.lifeform.role;

public class EnemySlime extends EnemyMonster{
	

	public EnemySlime(int strength, int defense) {
		super(strength, defense);
		super.setType("Feindlicher Schleim");
	}

	@Override
	public void kill() {
		
	}


}
