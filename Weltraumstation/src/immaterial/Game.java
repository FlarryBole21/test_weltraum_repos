package immaterial;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

import space.Galaxy;
import space.SolarSystem;
import space.Universe;
import space.celestial.Planet;
import space.celestial.star.MainSequenceStar;

public class Game {

	private final static String PLANETCREATEPATH = "data/planetCreate";
	private final static String SUNCREATEPATH = "data/sunCreate";
	private final static String MOONCREATEPATH = "data/moonCreate";
	private final static File[] FILES = { new File("./" + Game.PLANETCREATEPATH + ".txt"),
			new File("./" + Game.SUNCREATEPATH + ".txt"), new File("./" + Game.MOONCREATEPATH + ".txt")

	};

	private Universe universe;

	public Game() {

	}

	public static void main(String[] args) {
		try {
			testFiles();
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
		System.out.println("Folgende Sonnensysteme hast du erstellt: " + galaxy.getSolarSystemsNames());
		askUniversalInfo(scanner, galaxy);

	}

	public Galaxy setGalaxy(Scanner scanner) throws RuntimeException {
		String input;
		System.out.println("Als Erstes brauchen wir ein Universum!");
		System.out.print("Bitte gebe dem Universum einen Namen: ");
		input = scanner.nextLine();
		universe = new Universe(input);
		universe.setPlanetdata(readFile(Game.PLANETCREATEPATH + ".txt"));
		universe.setSundata(readFile(Game.SUNCREATEPATH + ".txt"));
		universe.setMoondata(readFile(Game.MOONCREATEPATH + ".txt"));
		System.out.println("Als Zweites brauchen wir eine Galaxie!");
		System.out.print("Bitte gebe deiner Galaxie einen Namen: ");
		input = scanner.nextLine();
		Galaxy galaxy = universe.addGalaxy(input);
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

	public void askUniversalInfo(Scanner scanner, Galaxy galaxy) {
		String input;
		System.out.println("-------------------------------------");
		System.out.println("<SPOILER> Planten-, Sonnen- & Mond-Daten einsehen?");
		System.out.println("Achtung! Nur einmaliger Blick, Danach müssen Planeten & Monde kolonisiert werden, "
				+ "um Informationen zu erhalten");
		System.out.print(
				"(1 -> Nur Namen, 2 -> Detailreiche Infos, Irgendwas anderes -> Keine Infos, möchte selber erforschen): ");
		input = scanner.nextLine();
		System.out.println();
		if (input.equals("1")) {
			for (int i = 0; i < galaxy.getSolarSystems().size(); i++) {
				System.out.println("-- Sonnensystem <" + galaxy.getSolarSystemsNames().get(i) + "> --");
				System.out.println("Planeten-Namen <" + galaxy.getSolarSystems().get(i).getPlanetNames() + ">");
				System.out.println("Sonnen-Namen <" + galaxy.getSolarSystems().get(i).getSunNames() + ">");
				System.out
						.println("Hauptsequenzstern <" + galaxy.getSolarSystems().get(i).getMainstar().getName() + ">");
				for (int j = 0; j < galaxy.getSolarSystems().get(i).getPlanets().size(); j++) {
					String planetName = galaxy.getSolarSystems().get(i).getPlanets().get(j).getName();
					if (galaxy.getSolarSystems().get(i).getPlanets().get(j).getMoons().size() != 0) {
						System.out.println("Mond-Namen <Planet " + planetName + "> <"
								+ galaxy.getSolarSystems().get(i).getPlanets().get(j).getMoonNames() + ">");
					} else {
						System.out.println("Mond-Namen <Planet " + planetName + "> <Keine Monde vorhanden>");
					}

				}
				System.out.println();

			}

		} else if (input.equals("2")) {
			for (int i = 0; i < galaxy.getSolarSystems().size(); i++) {
				System.out.println("||<----- Sonnensystem <" + galaxy.getSolarSystemsNames().get(i) + "> ----->||");
				System.out.println();
				System.out.println("|<-- Sonnen-Daten -->|");
				System.out.println();
				System.out
						.println("Hauptsequenzstern <" + galaxy.getSolarSystems().get(i).getMainstar().getName() + ">");
				System.out.println();
				for (int k = 0; k < galaxy.getSolarSystems().get(i).getSuns().size(); k++) {
					System.out.println("|<-- Sonnen-Daten <"
							+ galaxy.getSolarSystems().get(i).getSuns().get(k).getName() + "> -->|");
					System.out.println();
					for (int b = 0; b < galaxy.getSolarSystems().get(i).getSuns().get(k).getInformation().size(); b++) {
						System.out.println(galaxy.getSolarSystems().get(i).getSuns().get(k).getInformation().get(b));

					}

					if (k != galaxy.getSolarSystems().get(i).getSuns().size() - 1) {
						System.out.println();
					}

				}

				System.out.println();
				System.out.println("|<-- Planeten-Daten -->|");
				System.out.println();

				for (int j = 0; j < galaxy.getSolarSystems().get(i).getPlanets().size(); j++) {
					System.out.println("|<-- Planeten-Daten <"
							+ galaxy.getSolarSystems().get(i).getPlanets().get(j).getName() + "> -->|");
					System.out.println();
					for (int b = 0; b < galaxy.getSolarSystems().get(i).getPlanets().get(j).getInformation()
							.size(); b++) {
						System.out.println(galaxy.getSolarSystems().get(i).getPlanets().get(j).getInformation().get(b));

					}
					if (j != galaxy.getSolarSystems().get(i).getSuns().size() - 1) {
						System.out.println();
					}
				}

				System.out.println();
				System.out.println("|<-- Mond-Daten -->|");
				System.out.println();

				for (int m = 0; m < galaxy.getSolarSystems().get(i).getPlanets().size(); m++) {
					String planetName = galaxy.getSolarSystems().get(i).getPlanets().get(m).getName();
					if (galaxy.getSolarSystems().get(i).getPlanets().get(m).getMoons().size() != 0) {
						for (int n = 0; n < galaxy.getSolarSystems().get(i).getPlanets().get(m).getMoons()
								.size(); n++) {
							System.out.println("|<-- Mond-Daten <"
									+ galaxy.getSolarSystems().get(i).getPlanets().get(m).getMoons().get(n).getName()
									+ ">-->|");
							System.out.println();

							for (int b = 0; b < galaxy.getSolarSystems().get(i).getPlanets().get(m).getMoons().get(n)
									.getInformation().size(); b++) {
								System.out.println(galaxy.getSolarSystems().get(i).getPlanets().get(m).getMoons().get(n)
										.getInformation().get(b));

							}

							if (n != galaxy.getSolarSystems().get(i).getPlanets().get(m).getMoons().size() - 1) {
								System.out.println();
							}
						}

						if (m != galaxy.getSolarSystems().get(i).getPlanets().size() - 1) {
							System.out.println();
						}
					} else {
						System.out.println("Mond-Daten <Planet " + planetName + "> <Keine Monde vorhanden>");
					}

				}
				System.out.println();

			}

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

				if (errorCount >= 50) {
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
				if (errorCount >= 50) {
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

					if (errorCount >= 50) {
						throw new RuntimeException("Planeten konnten nicht ordungsgemäß erstellt werden!");
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

	public void moonsToPlanet(Planet planet) {
		for (int m = 0; m < planet.getMoons().size(); m++) {
			if (planet.getMoons().get(m).getPlanet() == null) {
				planet.getMoons().get(m).setPlanet(planet);
			}
		}
	}

	public void mainLoop() {

	}

	public static LinkedList<String> readFile(String path) {
		LinkedList<String> rows = null;
		try {
			File datei = new File(path);
			Scanner scanner = new Scanner(datei);
			rows = new LinkedList<>();
			while (scanner.hasNextLine()) {
				rows.add(scanner.nextLine());
			}
			scanner.close();
			return rows;
		} catch (FileNotFoundException e) {
			System.out.println("Datei nicht gefunden: " + e.getMessage());
		}

		return rows;
	}

	public static void testFiles() throws IOException {

		String[] textData = new String[FILES.length];
		textData[0] = FileData.getPlanetdata();
		textData[1] = FileData.getSundata();
		textData[2] = FileData.getMoondata();

		for (int i = 0; i < FILES.length; i++) {
			if (!FILES[i].exists()) {
				createFileAndWrite(FILES[i], textData[i]);
			}
		}
	}

	public static void createFileAndWrite(File path, String text) throws IOException {
		path.createNewFile();
		FileWriter writer = new FileWriter(path);
		writer.write(text);
		writer.close();

	}

}
