package space.inventory.item.suit;

import java.util.LinkedList;

import immaterial.effect.Buff;
import space.Upgradable;
import space.inventory.item.Item;

public abstract class Suit extends Item implements Wearable, Upgradable{
	
	private static final long serialVersionUID = 1L;
	private int defense;
	private LinkedList<Buff> buffs;
	
	public Suit(int defense) {
		this.defense = defense;
	}
	
	
	public LinkedList<Buff> getBuffs() {
		return buffs;
	}


	public void setBuffs(LinkedList<Buff> buffs) {
		this.buffs = buffs;
	}
	

}
