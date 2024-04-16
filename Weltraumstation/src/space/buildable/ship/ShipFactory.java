package space.buildable.ship;

import java.util.LinkedList;
import space.buildable.Factory;
import space.inventory.item.Item;

public class ShipFactory extends Factory {

	public ShipFactory(String name) {
		super(name);
	}
	
	public BattleShip craftBattleShip(LinkedList<Item> items, int amount){
		
		return new BattleShip(1000,750,20);
		
	}
	
	public ColonyShip craftColonyShip(LinkedList<Item> items, int amount){
		
		return new ColonyShip(1000,50);
		
	}
	
	public CargoShip craftCargoShip(LinkedList<Item> items, int amount){
		
		return new CargoShip(1000,50);
	}

}
