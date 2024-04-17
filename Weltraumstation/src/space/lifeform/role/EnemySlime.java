package space.lifeform.role;

public class EnemySlime extends EnemyMonster{
	
	public EnemySlime(String name, int strength, int defense) {
		super(name, strength, defense);
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "Feindlicher Schleim";
	}

	@Override
	public void kill() {
		
	}

}
