package space.lifeform.role;

import java.util.LinkedList;

import immaterial.Game;
import immaterial.effect.Effect;
import immaterial.effect.Normal;
import space.Enterable;
import space.SolarSystem;
import space.Upgradable;
import space.buildable.ship.BattleShip;
import space.buildable.ship.Ship;
import space.celestial.Moon;
import space.celestial.Planet;
import space.inventory.InventoryObject;
import space.lifeform.Human;
import space.lifeform.Killable;

public class Player extends Human implements Upgradable, Killable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private double strengthExperience;
	private double healthExperience;
	private double miningExperience;
	private double harvestExperience;
	private double woodCuttingExperience;
	private double cookingExperience;
	private double craftingExperience;
	private double buildingExperience;
	private int overAllLevel;
	private Effect statusEffect;
	private SolarSystem currentSystem;
	private Enterable currentPlace;
	private Ship currentShip;
	private LinkedList<InventoryObject> inventory;
	private LinkedList<Planet> visitedPlanets;
	private LinkedList<Moon> visitedMoons;

	public Player(String name) {
		super(4, 10);
		super.setType("Spieler");
		this.name = name;
		this.inventory = new LinkedList<>();
		this.strengthExperience=super.getStrength();
		this.healthExperience=super.getHealth();
		this.miningExperience=1;
		this.harvestExperience=1;
		this.woodCuttingExperience=1;
		this.cookingExperience=1;
		this.craftingExperience=1;
		this.buildingExperience=1;
		setOverallLevel();
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

	
	public Effect getStatusEffect() {
		return statusEffect;
	}
	
	public void setStatusEffect(Effect statusEffect) {
	     this.statusEffect = statusEffect;
	}
	
	public double getOverallLevel() {
		return overAllLevel;
	}

	public void setOverallLevel() {
		this.overAllLevel = (int)strengthExperience+(int)healthExperience+(int)miningExperience+
				(int)harvestExperience+(int)woodCuttingExperience+(int)cookingExperience
				+(int)craftingExperience+(int)buildingExperience;
	}
	
	
	public double getMiningExperience() {
		return miningExperience;
	}

	public void setMiningExperience(double miningExperience) {
		this.miningExperience += miningExperience;
	}
	
	public void setStrengthExperience(double strengthExperience) {
		this.strengthExperience += strengthExperience;
		super.setStrength((int)this.strengthExperience);
	}
	
	public void setHealthExperience(double healthExperience) {
		this.healthExperience += healthExperience;
		super.setHealth((int)this.healthExperience);
	}

	public double getHarvestExperience() {
		return harvestExperience;
	}

	public void setHarvestExperience(double harvestExperience) {
		this.harvestExperience += harvestExperience;
	}

	public double getWoodCuttingExperience() {
		return woodCuttingExperience;
	}

	public void setWoodCuttingExperience(double woodCuttingExperience) {
		this.woodCuttingExperience += woodCuttingExperience;
	}

	public double getCookingExperience() {
		return cookingExperience;
	}

	public void setCookingExperience(double cookingExperience) {
		this.cookingExperience += cookingExperience;
	}

	public double getCraftingExperience() {
		return craftingExperience;
	}

	public void setCraftingExperience(double craftingExperience) {
		this.craftingExperience += craftingExperience;
	}

	public double getBuildingExperience() {
		return buildingExperience;
	}

	public void setBuildingExperience(double buildingExperience) {
		this.buildingExperience += buildingExperience;
	}

	public LinkedList<String> getInformation() {
		LinkedList<String> information = new LinkedList<>();
		information.add("Name <" + name+">");
		information.add("Typ <" + super.getType()+">");
		information.add("Gesamt-Level <" + ((int)overAllLevel) + ">");
		information.add("Stärke <" + super.getStrength() + "> "
		        + "<" +  Game.MATHORACLE.calcPercent(strengthExperience) + "%>");
		information.add("Lebenspunkte <" + super.getHealth() + "> "
		        + "<" +  Game.MATHORACLE.calcPercent(healthExperience) + "%>");
		information.add("Bergbau-Level <" + ((int)miningExperience) + "> "
		        + "<" +  Game.MATHORACLE.calcPercent(miningExperience) + "%>");
		information.add("Ernte-Level <" + ((int)harvestExperience) + "> "
		        + "<" +  Game.MATHORACLE.calcPercent(harvestExperience) + "%>");
		information.add("Holzfäller-Level <" + ((int)woodCuttingExperience) + "> "
		        + "<" + Game.MATHORACLE.calcPercent(woodCuttingExperience) + "%>");
		information.add("Koch-Level <" + ((int)cookingExperience) + "> "
		        + "<" + Game.MATHORACLE.calcPercent(cookingExperience) + "%>");
		information.add("Crafting-Level <" + ((int)craftingExperience) + "> "
		        + "<" + Game.MATHORACLE.calcPercent(craftingExperience) + "%>");
		information.add("Bau-Level <" + ((int)buildingExperience) + "> "
		        + "<" + Game.MATHORACLE.calcPercent(buildingExperience) + "%>");
		information.add("Aktueller Status-Effekt <" + statusEffect.getType() + ">");

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
	public void upgrade(Runnable setExperience) {
		setExperience.run();
		setOverallLevel();
	}

	@Override
	public void kill() {
		this.setHealth(0);
		
	}

	

}
