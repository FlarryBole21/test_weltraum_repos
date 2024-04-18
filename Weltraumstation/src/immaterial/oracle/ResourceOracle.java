package immaterial.oracle;

import space.SolarSystem;
import space.inventory.resource.Apple;
import space.inventory.resource.Banana;
import space.inventory.resource.BlueBerry;
import space.inventory.resource.Chronium;
import space.inventory.resource.Copper;
import space.inventory.resource.Crystal;
import space.inventory.resource.Dattel;
import space.inventory.resource.Gold;
import space.inventory.resource.Iron;
import space.inventory.resource.Mango;
import space.inventory.resource.MapleWood;
import space.inventory.resource.Nanite;
import space.inventory.resource.NormalWood;
import space.inventory.resource.OakWood;
import space.inventory.resource.Plasma;
import space.inventory.resource.Silver;
import space.inventory.resource.Stellarite;
import space.inventory.resource.StrawBerry;
import space.inventory.resource.TeakWood;
import space.inventory.resource.Titan;
import space.inventory.resource.WillowWood;

public abstract class ResourceOracle extends Oracle {

	private static final int LEVEL1 = 1;
	private static final int LEVEL2 = 5;
	private static final int LEVEL3 = 10;
	private static final int LEVEL4 = 15;
	private static final int LEVEL5 = 20;
	private static final int LEVEL6 = 25;
	private static final int LEVEL7 = 30;

	private static Crystal getCrystal() {
		return new Crystal(LEVEL1);
	}

	private static NormalWood getNormalWood() {
		return new NormalWood(LEVEL1);
	}

	private static Copper getCopper() {
		return new Copper(LEVEL1);
	}

	private static Iron getIron() {
		return new Iron(LEVEL2);
	}

	private static Apple getApple() {
		return new Apple(LEVEL2);
	}

	private static Banana getBanana() {
		return new Banana(LEVEL4);
	}

	private static BlueBerry getBlueBerry() {
		return new BlueBerry(LEVEL1);
	}

	private static Dattel getDattel() {
		return new Dattel(LEVEL2);
	}
	
	private static Silver getSilver() {
		return new Silver(LEVEL4);
	}
	
	private static Gold getGold() {
		return new Gold(LEVEL6);
	}

	private static Mango getMango() {
		return new Mango(LEVEL6);
	}

	private static MapleWood getMapleWood() {
		return new MapleWood(LEVEL5);
	}

	private static Nanite getNanite() {
		return new Nanite(LEVEL6);
	}

	private static OakWood getOakWood() {
		return new OakWood(LEVEL2);
	}

	private static Plasma getPlasma() {
		return new Plasma(LEVEL7);
	}

	private static StrawBerry getStrawBerry() {
		return new StrawBerry(LEVEL1);
	}

	private static TeakWood getTeakWood() {
		return new TeakWood(LEVEL4);
	}

	private static Titan getTitan() {
		return new Titan(LEVEL5);
	}

	private static WillowWood getWillowWood() {
		return new WillowWood(LEVEL3);
	}
	
	private static Chronium getChronium() {
		return new Chronium(LEVEL6);
	}
	
	private static Stellarite getStellarite() {
		return new Stellarite(LEVEL6);
	}

	public static void basicResources(SolarSystem solarsystem, int planetNumber) {
		for (int j = 0; j < 500; j++) {
			if(j < 100) {
				solarsystem.getPlanets().get(planetNumber).addResource(getIron());
			}
			
			if(j < 200) {
				solarsystem.getPlanets().get(planetNumber).addResource(getNormalWood());
				solarsystem.getPlanets().get(planetNumber).addResource(getCopper());
			}
			
			solarsystem.getPlanets().get(planetNumber).addResource(getCrystal());
		}
	}

	public static void addResourcesCategoryA(SolarSystem solarsystem, int planetNumber) {
		int randomResourceNumber = (int) (Math.random() * (4));
		int randomResourceNumber2 = (int) (Math.random() * (2));
		int randomResourceNumber3 = (int) (Math.random() * (2));

		for (int j = 0; j < 200; j++) {
			solarsystem.getPlanets().get(planetNumber).addResource(getDattel());
			solarsystem.getPlanets().get(planetNumber).addResource(getBlueBerry());
			solarsystem.getPlanets().get(planetNumber).addResource(getWillowWood());
			if(j < 100) {
				solarsystem.getPlanets().get(planetNumber).addResource(getSilver());
			}
			
			if(j < 50 && randomResourceNumber >= 1) {
				solarsystem.getPlanets().get(planetNumber).addResource(getTitan());
				
				if(randomResourceNumber3 == 1) {
					solarsystem.getPlanets().get(planetNumber).addResource(getGold());
				}
			}
			
			if(j < 30 && randomResourceNumber >= 2) {
				if(randomResourceNumber2 == 1) {
					solarsystem.getPlanets().get(planetNumber).addResource(getNanite());
				}else {
					solarsystem.getPlanets().get(planetNumber).addResource(getChronium());
				}
			}
			
			if(j < 10 && randomResourceNumber == 3) {
				solarsystem.getPlanets().get(planetNumber).addResource(getPlasma());
			}
		}
		
		basicResources(solarsystem, planetNumber);
	}

	public static void addResourcesCategoryB(SolarSystem solarsystem, int planetNumber) {
		int randomResourceNumber = (int) (Math.random() * (3));
		
		for (int j = 0; j < 200; j++) {
			solarsystem.getPlanets().get(planetNumber).addResource(getStrawBerry());
			solarsystem.getPlanets().get(planetNumber).addResource(getOakWood());
			solarsystem.getPlanets().get(planetNumber).addResource(getApple());
			
			if(j < 100 && randomResourceNumber >= 1) {
				solarsystem.getPlanets().get(planetNumber).addResource(getWillowWood());
			}
			
			if(randomResourceNumber >= 1) {
				solarsystem.getPlanets().get(planetNumber).addResource(getSilver());
			}
			
			if(j < 20 && randomResourceNumber >= 1) {
				solarsystem.getPlanets().get(planetNumber).addResource(getTitan());
			}
			
			if(j < 20 && randomResourceNumber >= 2) {
				solarsystem.getPlanets().get(planetNumber).addResource(getChronium());
			}
		}
		
		basicResources(solarsystem, planetNumber);
	}

	public static void addResourcesCategoryC(SolarSystem solarsystem, int planetNumber) {
		int randomResourceNumber = (int) (Math.random() * (3));
		int randomResourceNumber2 = (int) (Math.random() * (2));

		for (int j = 0; j < 200; j++) {
			solarsystem.getPlanets().get(planetNumber).addResource(getBanana());
			solarsystem.getPlanets().get(planetNumber).addResource(getTeakWood());
			
			if(randomResourceNumber >= 1 && j < 20) {
				solarsystem.getPlanets().get(planetNumber).addResource(getGold());
			}
			
			if(randomResourceNumber >= 1 && j < 200) {
				solarsystem.getPlanets().get(planetNumber).addResource(getMango());
			}
			
			if(randomResourceNumber == 2 && j < 10) {
				solarsystem.getPlanets().get(planetNumber).addResource(getNanite());
			}
			
			if(j < 10 && randomResourceNumber == 2 && randomResourceNumber2 == 1) {
				solarsystem.getPlanets().get(planetNumber).addResource(getPlasma());
			}
		}
		

		basicResources(solarsystem, planetNumber);
	}

	public static void addResourcesCategoryD(SolarSystem solarsystem, int planetNumber) {
		int randomResourceNumber = 0;
		randomResourceNumber = (int) (Math.random() * (3));

		for (int j = 0; j < 200; j++) {
			solarsystem.getPlanets().get(planetNumber).addResource(getBlueBerry());
			solarsystem.getPlanets().get(planetNumber).addResource(getApple());
			solarsystem.getPlanets().get(planetNumber).addResource(getMapleWood());
			
			if(j < 20 && randomResourceNumber >= 1) {
				solarsystem.getPlanets().get(planetNumber).addResource(getTitan());
				solarsystem.getPlanets().get(planetNumber).addResource(getSilver());
			}
			
			if(j < 10 && randomResourceNumber >= 2) {
				solarsystem.getPlanets().get(planetNumber).addResource(getStellarite());
				solarsystem.getPlanets().get(planetNumber).addResource(getChronium());
			}
		}
		

		basicResources(solarsystem, planetNumber);
	}
}
