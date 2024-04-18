package immaterial;



import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import immaterial.oracle.AskOracle;
import immaterial.oracle.FileOracle;
import immaterial.oracle.ResourceOracle;
import space.Galaxy;
import space.SolarSystem;
import space.Universe;
import space.celestial.Planet;
import space.celestial.star.MainSequenceStar;

public class Game {

	private Universe universe;

	public static void main(String[] args) {
		try {
			FileOracle.testFiles();
			Game game = new Game();
			game.start();
			game.mainLoop();
		} catch (FileNotFoundException e) {
			System.err.println("FileNotFoundException --> " + e.getMessage() + "!");
		} catch (IOException e) {
			System.err.println("IOException --> " + e.getMessage() + "!");
		} catch (NumberFormatException e) {
			System.err.println("NumberFormatException --> " + e.getMessage() + "!");
		} catch (RuntimeException e) {
			System.err.println("RuntimeException --> " + e.getMessage() + "!");
		} catch (Exception e) {
			System.err.println("Exception --> " + e.getMessage() + "!");
		} finally {
			System.out.println("Programm wird beendet!");
		}

	}
	
	public void start() throws RuntimeException {
		System.out.println("Willkommen in der Weltraumsimulation");
		Scanner scanner = new Scanner(System.in);
		Galaxy galaxy = setGalaxy(scanner);
		setSolar(scanner, galaxy);
		AskOracle.askUniverseInfo(scanner, galaxy);
		AskOracle.askSunSystemInfo(scanner, galaxy);
		AskOracle.askMoonInfo(scanner, galaxy);

	}

	public Galaxy setGalaxy(Scanner scanner) throws RuntimeException {
		String input;
		System.out.println("Als Erstes brauchen wir ein Universum!");
		System.out.print("Bitte gebe dem Universum einen Namen: ");
		input = scanner.nextLine();
		universe = new Universe(input);
		universe.setPlanetdata(FileOracle.readFile(FileOracle.getPlanetCreatePath() + ".txt"));
		universe.setSundata(FileOracle.readFile(FileOracle.getSunCreatePath()+ ".txt"));
		universe.setMoondata(FileOracle.readFile(FileOracle.getMoonCreatePath() + ".txt"));
		System.out.println("Als Zweites brauchen wir eine Galaxie!");
		System.out.print("Bitte gebe deiner Galaxie einen Namen: ");
		input = scanner.nextLine();
		Galaxy galaxy = universe.addGalaxy(input);
		galaxy.setUniverse(universe);
		return galaxy;
	}

	public void setSolar(Scanner scanner, Galaxy galaxy) throws RuntimeException {
		String input;
		int numberInput;
		System.out.println(
				"Als Nächstes brauchen wir Sonnensysteme! (Planten, Sonnen, Monde etc. werden zufällig erstellt)");
		while (true) {
			System.out.print("Wie viele Sonnensysteme möchtest du deiner Galaxie hinzufügen ? (MIN 1 - MAX 3): ");
			input = scanner.nextLine();
			try {
				numberInput = Integer.valueOf(input);
				if (numberInput >= 1 && numberInput <= 3) {
					break;
				} else {
					System.err.println("Error --> Zahl ist zu hoch oder zu niedrig!");
				}
			} catch (RuntimeException e) {
				System.err.println("Error --> " + e.getMessage() + "!");
			}

		}
		for (int i = 0; i < numberInput; i++) {
			if (numberInput > 1) {
				System.out.print("Bitte gebe den Namen für das " + (i + 1) + ".Sonnensystem ein: ");
			} else {
				System.out.print("Bitte gebe den Namen für das Sonnensystem ein: ");
			}
			input = scanner.nextLine();
			SolarSystem solarsystem = galaxy.addSolarSystem(input);
			createRandomSolarSystem(solarsystem);
		}

	}

	public void createRandomSolarSystem(SolarSystem solarsystem) throws RuntimeException {
		int randomPlanetNumber = 0;
		int randomSunNumber = 0;
		int randomMoonNumber = 0;
		do {
			randomPlanetNumber = (int) (Math.random() * (10));
			randomSunNumber = (int) (Math.random() * (10)) - ((int) randomPlanetNumber / 2);
		} while ((randomSunNumber + 2) > randomPlanetNumber || randomPlanetNumber < 3 || randomSunNumber < 1);

		createRandomPlanets(solarsystem, randomPlanetNumber);
		resourcesToPlanets(solarsystem);
		createRandomSuns(solarsystem, randomSunNumber);
		createRandomMoons(solarsystem, randomMoonNumber);
		
	}

	public void createRandomPlanets(SolarSystem solarsystem, int randomPlanetNumber) {
		boolean normalAtmosphere = false;
		for (int i = 0; i < randomPlanetNumber; i++) {
			String[] randomData;
			int randomIndex;
			int errorCount = 0;
			String atmosphereType;
			while (true) {
				randomIndex = (int) (Math.random() * universe.getPlanetdata().size());
				randomData = universe.getPlanetdata().get(randomIndex).split(" ");
				atmosphereType = universe.getAtmospheres().get((Integer.valueOf(randomData[4]))).getType();
				if (atmosphereType.equals("Normal")) {
					normalAtmosphere = true;
				}

				if (randomData.length > 1 && (i != randomPlanetNumber - 1)) {
					break;
				} else if ((randomData.length > 1) && (i == randomPlanetNumber - 1) && (normalAtmosphere)) {
					break;
				} else {
					errorCount++;
				}

				if (errorCount >= 100) {
					throw new RuntimeException("Planeten konnten nicht ordungsgemäß erstellt werden!");
				}
			}
			universe.getPlanetdata().remove(randomIndex);
			solarsystem.addPlanet(randomData[0], Double.valueOf(randomData[1]), Double.valueOf(randomData[2]),
					Double.valueOf(randomData[1]), universe.getAtmospheres().get((Integer.valueOf(randomData[4]))),
					universe.getTerrains().get((Integer.valueOf(randomData[5]))));

		}

	}

	public void createRandomSuns(SolarSystem solarsystem, int randomSunNumber) {
		boolean mainStar = false;
		for (int i = 0; i < randomSunNumber; i++) {
			String[] randomData;
			int randomIndex;
			int errorCount = 0;
			String starType;
			while (true) {
				if (!mainStar) {
					randomIndex = (int) (Math.random() * universe.getSundata().size());
					randomData = universe.getSundata().get(randomIndex).split(" ");
					starType = universe.getSuns().get((Integer.valueOf(randomData[5]))).getType();

					if (starType.equals("Hauptsequenzstern")) {
						mainStar = true;
					}
				} else {
					do {
						randomIndex = (int) (Math.random() * universe.getSundata().size());
						randomData = universe.getSundata().get(randomIndex).split(" ");
						starType = universe.getSuns().get((Integer.valueOf(randomData[5]))).getType();
					} while (starType.equals("Hauptsequenzstern"));

				}
				if (randomData.length > 1 && (i != randomSunNumber - 1)) {
					break;
				} else if ((randomData.length > 1) && (i == randomSunNumber - 1) && (mainStar)) {
					break;
				} else {
					errorCount++;
				}
				if (errorCount >= 100) {
					throw new RuntimeException("Sonnen konnten nicht ordungsgemäß erstellt werden!");
				}
			}
			universe.getSundata().remove(randomIndex);
			solarsystem.addSun(randomData[0], Double.valueOf(randomData[1]), Double.valueOf(randomData[2]),
					Double.valueOf(randomData[3]), Double.valueOf(randomData[4]),
					universe.getSuns().get((Integer.valueOf(randomData[5]))));
			planetsToMainStar(solarsystem);
		}
	}

	public void planetsToMainStar(SolarSystem solarsystem) {
		for (int m = 0; m < solarsystem.getSuns().size(); m++) {
			if (solarsystem.getSuns().get(m) instanceof MainSequenceStar) {
				MainSequenceStar mainstar = (MainSequenceStar) solarsystem.getSuns().get(m);
				if (mainstar.getPlanetNames().size() > 0) {
					break;
				}
				solarsystem.setMainstar(mainstar);
				for (int n = 0; n < solarsystem.getPlanets().size(); n++) {
					mainstar.addPlanet(solarsystem.getPlanets().get(n));
					solarsystem.getPlanets().get(n).setMainstar(mainstar);
				}
				break;
			}
		}
	}

	public void createRandomMoons(SolarSystem solarsystem, int randomMoonNumber) throws RuntimeException {
		MainSequenceStar mainstar = solarsystem.getMainstar();

		for (int i = 0; i < mainstar.getPlanets().size(); i++) {
			randomMoonNumber = (int) (Math.random() * (5));

			for (int j = 0; j < randomMoonNumber; j++) {
				String[] randomData;
				int randomIndex;
				int errorCount = 0;
				while (true) {
					randomIndex = (int) (Math.random() * universe.getMoondata().size());
					randomData = universe.getMoondata().get(randomIndex).split(" ");

					if (randomData.length > 1) {
						break;
					} else {
						errorCount++;
					}

					if (errorCount >= 100) {
						throw new RuntimeException("Monde konnten nicht ordungsgemäß erstellt werden!");
					}

				}
				if (randomMoonNumber != 0) {
					universe.getMoondata().remove(randomIndex);
					mainstar.getPlanets().get(i).addMoon(randomData[0], Double.valueOf(randomData[1]),
							Double.valueOf(randomData[2]), Double.valueOf(randomData[3]),
							universe.getAtmospheres().get((Integer.valueOf(randomData[4]))));

					moonsToPlanet(mainstar.getPlanets().get(i));
				}
			}
		}
	}
	
	public void resourcesToPlanets(SolarSystem solarsystem) {
		
		int randomResourceNumber = (int) (Math.random() * (3));

		for(int i=0; i < solarsystem.getPlanets().size(); i++) {
			
			switch (solarsystem.getPlanets().get(i).getTerrain().getType()) {
            case "Canyon":
            	ResourceOracle.addResourcesCategoryA(solarsystem, i);
                break;
            case "Krater":
            	ResourceOracle.addResourcesCategoryA(solarsystem, i);
                break;
            case "Wüste":
            	ResourceOracle.addResourcesCategoryA(solarsystem, i);
            	break;
            case "Grassland":
            	ResourceOracle.addResourcesCategoryB(solarsystem, i);
                break;
            case "Dschungel":
            	ResourceOracle.addResourcesCategoryC(solarsystem, i);
                break;
            case "Berge":
            	ResourceOracle.addResourcesCategoryD(solarsystem, i);
                break;
            case "Normaler Wald":
            	if(randomResourceNumber == 2) {
            		ResourceOracle.addResourcesCategoryD(solarsystem, i);
            	}else {
            		ResourceOracle.addResourcesCategoryB(solarsystem, i);
            	}
            	
                break;
            case "Savanne":
            	ResourceOracle.addResourcesCategoryC(solarsystem, i);
                break;
            case "Sumpf":
            	ResourceOracle.addResourcesCategoryB(solarsystem, i);
                break;
            case "Tundra":
            	ResourceOracle.addResourcesCategoryD(solarsystem, i);
                break;
            case "Vulkangebiet":
            	ResourceOracle.addResourcesCategoryA(solarsystem, i);
                break;
            default:
            	throw new RuntimeException("Planeten hat einen ungültigen Terrain-Typ!");
        }
		}
		
	}

	public void moonsToPlanet(Planet planet) {
		for (int m = 0; m < planet.getMoons().size(); m++) {
			if (planet.getMoons().get(m).getPlanet() == null) {
				planet.getMoons().get(m).setPlanet(planet);
			}
		}
	}

	public void mainLoop() {

	}

	

}
