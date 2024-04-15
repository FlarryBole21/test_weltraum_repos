package space.suit;

import java.util.LinkedList;

import space.effect.Buff;
import space.item.Item;
import space.simulation.Upgradable;

public abstract class Suit extends Item implements Wearable, Upgradable{
	
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
