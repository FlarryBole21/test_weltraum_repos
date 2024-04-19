package space.lifeform.role;

import java.util.LinkedList;

import immaterial.effect.Effect;
import immaterial.effect.Normal;
import space.Enterable;
import space.SolarSystem;
import space.Upgradable;
import space.buildable.ship.BattleShip;
import space.buildable.ship.Ship;
import space.celestial.Moon;
import space.celestial.Planet;
import space.inventory.Collectable;
import space.inventory.InventoryObject;
import space.lifeform.Human;
import space.lifeform.Killable;

public class Player extends Human implements Upgradable, Killable{
	
	private static final long serialVersionUID = 1L;
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
	private Ship currentShip;
	private LinkedList<InventoryObject> inventory;
	private LinkedList<Planet> visitedPlanets;
	private LinkedList<Moon> visitedMoons;

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
		this.currentShip = new BattleShip(10, 10, 100);
		this.visitedPlanets = new LinkedList<>();
		this.visitedMoons = new LinkedList<>();
	}
	
	public boolean getShipBool() {
		if(currentShip instanceof Ship) {
			return true;
		}else {
			return false;
		}
	}
	
	public LinkedList<String> getInventoryNames() {
		LinkedList<String> names = new LinkedList<>();
		for (int i = 0; i < getInventory().size(); i++) {
			names.add(getInventory().get(i).getType());
		}
		return names;
	}
	
	public LinkedList<String> getVisitedPlanetNames() {
		LinkedList<String> names = new LinkedList<>();
		for (int i = 0; i < getVisitedPlanets().size(); i++) {
			names.add(getVisitedPlanets().get(i).getType());
		}
		return names;
	}
	
	public LinkedList<String> getMoonNames() {
		LinkedList<String> names = new LinkedList<>();
		for (int i = 0; i < getVisitedMoons().size(); i++) {
			names.add(getVisitedMoons().get(i).getType());
		}
		return names;
	}
	
	public Ship getCurrentShip() {
		return currentShip;
	}

	public void setCurrentShip(Ship currentShip) {
		this.currentShip = currentShip;
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
	
	public LinkedList<InventoryObject> getInventory() {
		return inventory;
	}

	public LinkedList<Planet> getVisitedPlanets() {
		return visitedPlanets;
	}

	public void setVisitedPlanets(LinkedList<Planet> visitedPlanets) {
		this.visitedPlanets = visitedPlanets;
	}

	public LinkedList<Moon> getVisitedMoons() {
		return visitedMoons;
	}

	public void setVisitedMoons(LinkedList<Moon> visitedMoons) {
		this.visitedMoons = visitedMoons;
	}

	public void setInventory(LinkedList<InventoryObject> inventory) {
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
	
	public LinkedList<String> getInformation() {
		LinkedList<String> information = new LinkedList<>();
		information.add("Name <" + name+">");
		information.add("Stärke <" + super.getStrength()+">");
		information.add("Lebenspunkte <" + super.getHealth()+">");
		information.add("Typ <" + super.getType()+">");
		information.add("Bergbau-Level <" + miningLevel+">");
		information.add("Farm-Level <" + harvestLevel+">");
		information.add("Holzfäller-Level <" + woodCuttingLevel+">");
		information.add("Koch-Level <" + cookingLevel+">");
		information.add("Crafting-Level <" + craftingLevel+">");
		information.add("Bau-Level <" + buildingLevel+">");
		information.add("Aktueller Status-Effekt <" + statusEffect.getType()+">");
		information.add("Im Schiff <" + getShipBool()+">");
		if(getInventoryNames().size() != 0) {
			information.add("Inventar <" + getInventoryNames() +">");
		}else {
			information.add("Inventar <Inventar ist leer!>");
		}
		if(getVisitedPlanetNames().size() != 0) {
			information.add("Besuchte Planeten <" + getVisitedPlanetNames() +">");
		}else {
			information.add("Besuchte Planeten <Keine Planeten besucht!>");
		}
		if(getMoonNames().size() != 0) {
			information.add("Besuchte Monde <" + getMoonNames() +">");
		}else {
			information.add("Besuchte Monde <Keine Monde besucht!>");
		}
		return information;
		
	}

	@Override
	public void upgrade() {
		
	}

	@Override
	public void kill() {
		
	}

	

}
