package immaterial.oracle;

import space.SolarSystem;
import space.celestial.Planet;
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
import space.inventory.resource.Neutronium;
import space.inventory.resource.NormalWood;
import space.inventory.resource.OakWood;
import space.inventory.resource.Plasma;
import space.inventory.resource.QuantumVacuum;
import space.inventory.resource.Silver;
import space.inventory.resource.Stellarite;
import space.inventory.resource.StrawBerry;
import space.inventory.resource.TeakWood;
import space.inventory.resource.Titan;
import space.inventory.resource.WillowWood;

public class ResourceOracle extends Oracle {

	private static final int LEVEL1 = 1;
	private static final int LEVEL2 = 5;
	private static final int LEVEL3 = 10;
	private static final int LEVEL4 = 15;
	private static final int LEVEL5 = 20;
	private static final int LEVEL6 = 25;
	private static final int LEVEL7 = 30;
	private static final int LEVEL8 = 35;

	private Crystal getCrystal() {
		return new Crystal(LEVEL1,500);
	}

	private NormalWood getNormalWood() {
		return new NormalWood(LEVEL1,200);
	}

	private Copper getCopper() {
		return new Copper(LEVEL1,200);
	}

	private Iron getIron() {
		return new Iron(LEVEL2,100);
	}

	private Apple getApple() {
		return new Apple(LEVEL2,200);
	}

	private Banana getBanana() {
		return new Banana(LEVEL4,200);
	}

	private BlueBerry getBlueBerry() {
		return new BlueBerry(LEVEL1,200);
	}

	private Dattel getDattel() {
		return new Dattel(LEVEL2,200);
	}
	
	private Silver getSilver() {
		return new Silver(LEVEL4,100);
	}
	
	private Gold getGold() {
		return new Gold(LEVEL6,50);
	}

	private Mango getMango() {
		return new Mango(LEVEL6,200);
	}

	private MapleWood getMapleWood() {
		return new MapleWood(LEVEL5,200);
	}

	private Nanite getNanite() {
		return new Nanite(LEVEL6,30);
	}

	private OakWood getOakWood() {
		return new OakWood(LEVEL2,200);
	}

	private Plasma getPlasma() {
		return new Plasma(LEVEL7,10);
	}

	private StrawBerry getStrawBerry() {
		return new StrawBerry(LEVEL1,200);
	}

	private TeakWood getTeakWood() {
		return new TeakWood(LEVEL4,200);
	}

	private Titan getTitan() {
		return new Titan(LEVEL5,50);
	}

	private WillowWood getWillowWood() {
		return new WillowWood(LEVEL3,200);
	}
	
	private Chronium getChronium() {
		return new Chronium(LEVEL6,30);
	}
	
	private Stellarite getStellarite() {
		return new Stellarite(LEVEL6,10);
	}
	
	private QuantumVacuum getQuantumVaccum() {
		return new QuantumVacuum(LEVEL8,5);
	}
	
	private Neutronium getNeutronium() {
		return new Neutronium(LEVEL8,5);
	}
	
	private Neutronium getWaterMelon() {
		return new Neutronium(LEVEL7,100);
	}

	private void basicResources(SolarSystem solarsystem, int planetNumber) {
		solarsystem.getPlanets().get(planetNumber).addResource(getCrystal());
		solarsystem.getPlanets().get(planetNumber).addResource(getNormalWood());
		solarsystem.getPlanets().get(planetNumber).addResource(getCopper());
		solarsystem.getPlanets().get(planetNumber).addResource(getIron());
	}
	
	private void basicMoonResources(Planet planet, int moonNumber) {
		planet.getMoons().get(moonNumber).addResource(getCrystal());
		planet.getMoons().get(moonNumber).addResource(getIron());
	}

	public void addResourcesCategoryA(SolarSystem solarsystem, int planetNumber) {
		int randomResourceNumber = (int) (Math.random() * (4));
		int randomResourceNumber2 = (int) (Math.random() * (2));
		int randomResourceNumber3 = (int) (Math.random() * (2));
		
		solarsystem.getPlanets().get(planetNumber).addResource(getDattel());
		solarsystem.getPlanets().get(planetNumber).addResource(getBlueBerry());
		solarsystem.getPlanets().get(planetNumber).addResource(getWillowWood());
		solarsystem.getPlanets().get(planetNumber).addResource(getSilver());

		if(randomResourceNumber >= 1) {
			solarsystem.getPlanets().get(planetNumber).addResource(getTitan());
			
			if(randomResourceNumber3 == 1) {
				solarsystem.getPlanets().get(planetNumber).addResource(getGold());
			}
		}
	
		if(randomResourceNumber >= 2) {
			if(randomResourceNumber2 == 1) {
				solarsystem.getPlanets().get(planetNumber).addResource(getNanite());
			}else {
				solarsystem.getPlanets().get(planetNumber).addResource(getChronium());
			}
		}
		
		if(randomResourceNumber == 3) {
			solarsystem.getPlanets().get(planetNumber).addResource(getPlasma());
		}
	
		basicResources(solarsystem, planetNumber);
	}

	public void addResourcesCategoryB(SolarSystem solarsystem, int planetNumber) {
		int randomResourceNumber = (int) (Math.random() * (3));
		
		solarsystem.getPlanets().get(planetNumber).addResource(getStrawBerry());
		solarsystem.getPlanets().get(planetNumber).addResource(getOakWood());
		solarsystem.getPlanets().get(planetNumber).addResource(getApple());
		if(randomResourceNumber >= 1) {
			solarsystem.getPlanets().get(planetNumber).addResource(getWillowWood());
			solarsystem.getPlanets().get(planetNumber).addResource(getSilver());
			solarsystem.getPlanets().get(planetNumber).addResource(getTitan());
		}
		if(randomResourceNumber >= 2) {
			solarsystem.getPlanets().get(planetNumber).addResource(getChronium());
		}
		
		basicResources(solarsystem, planetNumber);
	}

	public void addResourcesCategoryC(SolarSystem solarsystem, int planetNumber) {
		int randomResourceNumber = (int) (Math.random() * (3));
		int randomResourceNumber2 = (int) (Math.random() * (2));
		
		solarsystem.getPlanets().get(planetNumber).addResource(getBanana());
		solarsystem.getPlanets().get(planetNumber).addResource(getTeakWood());
		if(randomResourceNumber >= 1) {
			solarsystem.getPlanets().get(planetNumber).addResource(getGold());
			solarsystem.getPlanets().get(planetNumber).addResource(getMango());
		}
		if(randomResourceNumber >= 2) {
			if(randomResourceNumber2 == 1) {
				solarsystem.getPlanets().get(planetNumber).addResource(getPlasma());
			}
			solarsystem.getPlanets().get(planetNumber).addResource(getWaterMelon());
			solarsystem.getPlanets().get(planetNumber).addResource(getNanite());
		}
		

		basicResources(solarsystem, planetNumber);
	}

	public void addResourcesCategoryD(SolarSystem solarsystem, int planetNumber) {
		int randomResourceNumber = 0;
		randomResourceNumber = (int) (Math.random() * (3));
		solarsystem.getPlanets().get(planetNumber).addResource(getBlueBerry());
		solarsystem.getPlanets().get(planetNumber).addResource(getApple());
		solarsystem.getPlanets().get(planetNumber).addResource(getMapleWood());
		if(randomResourceNumber >= 1) {
			solarsystem.getPlanets().get(planetNumber).addResource(getTitan());
			solarsystem.getPlanets().get(planetNumber).addResource(getSilver());
		}
		if(randomResourceNumber >= 2) {
			solarsystem.getPlanets().get(planetNumber).addResource(getStellarite());
			solarsystem.getPlanets().get(planetNumber).addResource(getChronium());
		}

		basicResources(solarsystem, planetNumber);
	}
	
	public void addResourcesCategoryE(Planet planet, int moonNumber) {
		int randomResourceNumber = 0;
		randomResourceNumber = (int) (Math.random() * (4));
		if(randomResourceNumber >= 1) {
			planet.getMoons().get(moonNumber).addResource(getTitan());
		}
		if(randomResourceNumber >= 2) {
			planet.getMoons().get(moonNumber).addResource(getStellarite());
		}
		if(randomResourceNumber >= 3) {
			planet.getMoons().get(moonNumber).addResource(getQuantumVaccum());
		}


		basicMoonResources(planet, moonNumber);
	}
	
	
	public void addResourcesCategoryF(Planet planet, int moonNumber) {
		int randomResourceNumber = 0;
		randomResourceNumber = (int) (Math.random() * (4));
		planet.getMoons().get(moonNumber).addResource(getSilver());
		if(randomResourceNumber >= 1) {
			planet.getMoons().get(moonNumber).addResource(getChronium());
		}
		if(randomResourceNumber >= 2) {
			planet.getMoons().get(moonNumber).addResource(getStellarite());
		}
		if(randomResourceNumber >= 3) {
			planet.getMoons().get(moonNumber).addResource(getNeutronium());
		}


		basicMoonResources(planet, moonNumber);
	}
	
	
	public void addResourcesCategoryG(Planet planet, int moonNumber) {
		int randomResourceNumber = 0;
		randomResourceNumber = (int) (Math.random() * (4));
		planet.getMoons().get(moonNumber).addResource(getGold());
		planet.getMoons().get(moonNumber).addResource(getSilver());
		if(randomResourceNumber >= 1) {
			planet.getMoons().get(moonNumber).addResource(getTitan());
			planet.getMoons().get(moonNumber).addResource(getPlasma());
			
		}
		if(randomResourceNumber >= 3) {
			planet.getMoons().get(moonNumber).addResource(getQuantumVaccum());
			planet.getMoons().get(moonNumber).addResource(getStellarite());
			planet.getMoons().get(moonNumber).addResource(getNeutronium());
		}


		basicMoonResources(planet, moonNumber);
	}
}
