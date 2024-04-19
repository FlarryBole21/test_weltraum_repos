package space.lifeform.role;

import java.util.LinkedList;

import immaterial.effect.Effect;
import space.Upgradable;
import space.inventory.Collectable;
import space.lifeform.Human;
import space.lifeform.Killable;

public class Player extends Human implements Upgradable, Killable{
	
	private LinkedList<Collectable> inventory;
	private int miningLevel;
	private int harvestLevel;
	private int woodCuttingLevel;
	private int cookingLevel;
	private int craftingLevel;
	private int buildingLevel;
	private Effect statusEffect;
	
	public Player(String name) {
		super(name, 1, 1);
		super.setType("Spieler");
		this.inventory = new LinkedList<>();
		this.miningLevel = 1;
		this.harvestLevel = 1;
		this.woodCuttingLevel = 1;
		this.cookingLevel = 1;
		this.craftingLevel = 1;
		this.buildingLevel = 1;
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

	@Override
	public void upgrade() {
		
	}

	@Override
	public void kill() {
		
	}

	

}
