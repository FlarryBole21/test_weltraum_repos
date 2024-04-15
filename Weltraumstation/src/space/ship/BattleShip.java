package space.ship;

import java.util.LinkedList;

import space.weapon.Weapon;

public class BattleShip extends Ship{
	private int strength;
	private LinkedList<Weapon> weapons;

	public BattleShip(int strength, int defense, int capacity) {
		super(defense, capacity);
		this.strength = strength;
	}

	@Override
	public void build() {
		
	}

	@Override
	public void demolition() {
		
	}

	@Override
	public void upgrade() {
		
	}
	
	public void addWeapon(Weapon weapon) {
		this.weapons.add(weapon);
	}
	


}
