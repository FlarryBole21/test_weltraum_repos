package space.lifeform.role;

public class EnemySlime extends EnemyMonster{
	

	public EnemySlime(String name, int strength, int defense) {
		super(name, strength, defense);
		super.setType("Feindlicher Schleim");
	}

	@Override
	public void kill() {
		
	}


}
