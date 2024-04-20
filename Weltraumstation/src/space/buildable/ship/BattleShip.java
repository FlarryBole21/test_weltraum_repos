package space.buildable.ship;

import java.util.LinkedList;

import space.inventory.item.weapon.Weapon;

public class BattleShip extends Ship{

	private static final long serialVersionUID = 1L;
	private int strength;
	private LinkedList<Weapon> weapons;

	public BattleShip(int strength, int defense, int capacity) {
		super(defense, capacity);
		super.setType("Kampfschiff");
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
	


}
