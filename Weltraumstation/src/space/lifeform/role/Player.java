package space.lifeform.role;

import java.util.LinkedList;

import immaterial.effect.Effect;
import immaterial.effect.Normal;
import space.Enterable;
import space.SolarSystem;
import space.Upgradable;
import space.inventory.Collectable;
import space.lifeform.Human;
import space.lifeform.Killable;

public class Player extends Human implements Upgradable, Killable{
	
	private LinkedList<Collectable> inventory;
	private String name;
	private int miningLevel;
	private int harvestLevel;
	private int woodCuttingLevel;
	private int cookingLevel;
	private int craftingLevel;
	private int buildingLevel;
	private Effect statusEffect;
	private SolarSystem currentSystem;
	private Enterable currentPlace;

	public Player(String name) {
		super(3, 10);
		super.setType("Spieler");
		this.name = name;
		this.inventory = new LinkedList<>();
		this.miningLevel = 1;
		this.harvestLevel = 1;
		this.woodCuttingLevel = 1;
		this.cookingLevel = 1;
		this.craftingLevel = 1;
		this.buildingLevel = 1;
		this.statusEffect = new Normal();
	}
	
	public SolarSystem getCurrentSystem() {
		return currentSystem;
	}

	public void setCurrentSystem(SolarSystem currentSystem) {
		this.currentSystem = currentSystem;
	}
	
	public Enterable getCurrentPlace() {
		return currentPlace;
	}

	public void setCurrentPlace(Enterable currentPlace) {
		this.currentPlace = currentPlace;
	}
	
	public LinkedList<Collectable> getInventory() {
		return inventory;
	}

	public void setInventory(LinkedList<Collectable> inventory) {
		this.inventory = inventory;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMiningLevel() {
		return miningLevel;
	}

	public void setMiningLevel(int miningLevel) {
		this.miningLevel = miningLevel;
	}

	public int getHarvestLevel() {
		return harvestLevel;
	}

	public void setHarvestLevel(int harvestLevel) {
		this.harvestLevel = harvestLevel;
	}

	public int getWoodCuttingLevel() {
		return woodCuttingLevel;
	}

	public void setWoodCuttingLevel(int woodCuttingLevel) {
		this.woodCuttingLevel = woodCuttingLevel;
	}

	public int getCookingLevel() {
		return cookingLevel;
	}

	public void setCookingLevel(int cookingLevel) {
		this.cookingLevel = cookingLevel;
	}

	public int getCraftingLevel() {
		return craftingLevel;
	}

	public void setCraftingLevel(int craftingLevel) {
		this.craftingLevel = craftingLevel;
	}

	public int getBuildingLevel() {
		return buildingLevel;
	}

	public void setBuildingLevel(int buildingLevel) {
		this.buildingLevel = buildingLevel;
	}
	
	public Effect getStatusEffect() {
		return statusEffect;
	}
	
	public void setStatusEffect(Effect statusEffect) {
	     this.statusEffect = statusEffect;
	}

	@Override
	public void upgrade() {
		
	}

	@Override
	public void kill() {
		
	}

	

}
