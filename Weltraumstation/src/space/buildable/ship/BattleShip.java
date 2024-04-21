package space.buildable.ship;

import java.util.LinkedList;

import space.inventory.item.weapon.Weapon;

public class BattleShip extends Ship{

	
	private static final long serialVersionUID = 1L;
	private int strength;
	private LinkedList<Weapon> weapons;

	public BattleShip(int strength, int health, int capacity) {
		super(health, capacity);
		super.setType("Kampfschiff");
		this.strength = strength;
	}
	
	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	@Override
	public void build() {
		
	}

	@Override
	public void demolition() {
		
	}

	
	public void addWeapon(Weapon weapon) {
		this.weapons.add(weapon);
	}
	
	@Override
	public LinkedList<String>  getInformation() {
		LinkedList<String> information = new LinkedList<>();
		information.add("Angriff <" + strength+">");
		information.add("Lebenspunkte <" + getHealth()+">");
		information.add("Kapazität <" + getCapacity()+">");
		information.add("Level <" + getLevel()+">");
		
		return information;
	}
	


}
