package immaterial.oracle;

import java.util.Scanner;

import space.Galaxy;
import space.SolarSystem;
import space.celestial.Moon;
import space.celestial.Planet;
import space.celestial.star.Sun;

public class AskOracle extends Oracle{
	
	
	public AskOracle() {
		super.setType("Orakel der Fragen");
	}
	
	public void askUniverseInfo(Scanner scanner, Galaxy galaxy) {
		String input;
		System.out.println("-------------------------------------");
		System.out.println("Universum-, Galaxie- & Sonnensystem-Daten einsehen?");
		System.out.print(
				"(1 -> Infos einsehen, Irgendwas anderes -> Keine Infos): ");
		input = scanner.nextLine();
		System.out.println();
		if (input.equals("1")) {
			System.out.println("Universum <"+ galaxy.getUniverse().getName() +">");
			System.out.println("Galaxie <"+ galaxy.getName() +">");
			for(SolarSystem solarsystem : galaxy.getSolarSystems()) {
				System.out.println("Sonnensystem <"+ solarsystem.getName() +">");
			}
		}
	}
	
	
	public void askSunSystemInfo(Scanner scanner, Galaxy galaxy) {
		String input;
		int count=0;
		System.out.println("-------------------------------------");
		System.out.println("Planten-, Sonnen- Daten einsehen?");
		System.out.print(
				"(1 -> Infos einsehen (Nur Namen), 2 -> Infos einsehen (Mehr Details), Irgendwas anderes -> Keine Infos): ");
		input = scanner.nextLine();
		System.out.println();
		if (input.equals("1")) {
			for (SolarSystem solarsystem : galaxy.getSolarSystems()) {
				System.out.println("-- Sonnensystem <" + solarsystem.getName() + "> --");
				System.out.println("Planeten-Namen <" + solarsystem.getPlanetNames() + ">");
				System.out.println("Sonnen-Namen <" + solarsystem.getSunNames() + ">");
				System.out.println();
			}
		} else if (input.equals("2")) {
			for (SolarSystem solarsystem : galaxy.getSolarSystems()) {
				System.out.println("||<----- Sonnensystem <" + solarsystem.getName() + "> ----->||");
				System.out.println();
				System.out.println("|<-- Sonnen-Daten -->|");
				System.out.println();
				System.out
						.println("Hauptsequenzstern <" + solarsystem.getMainstar().getName() + ">");
				System.out.println();
				count=0;
				for (Sun sun: solarsystem.getSuns()) {
					System.out.println("|<-- Sonnen-Daten <"+ sun.getName() + "> -->|");
					System.out.println();
					for(String information: sun.getInformation()) {
						System.out.println(information);
					}
					
					if (count != solarsystem.getSuns().size() - 1) {
						System.out.println();
					}
					count++;
				}
				System.out.println();
				System.out.println("|<-- Planeten-Daten -->|");
				System.out.println();
				count=0;
				for (Planet planet : solarsystem.getPlanets()) {
					System.out.println("|<-- Planeten-Daten <"+ planet.getName() + "> -->|");
					System.out.println();
					for (int b = 0; b < planet.getInformation()
							.size(); b++) {
						System.out.println(planet.getInformation().get(b));

					}
					if (count != solarsystem.getPlanets().size() - 1) {
						System.out.println();
					}
				}

			}

		}

	}
	
	
	public void askMoonInfo(Scanner scanner, Galaxy galaxy) {
		String input;
		System.out.println("-------------------------------------");
		System.out.println("Mond-Daten einsehen?");
		System.out.print(
				"(1 -> Infos einsehen (Nur Namen), 2 -> Infos einsehen (Mehr Details), Irgendwas anderes -> Keine Infos): ");
		input = scanner.nextLine();
		System.out.println();
		if (input.equals("1")) {
			for (SolarSystem solarsystem : galaxy.getSolarSystems()) {
				for (Planet planet : solarsystem.getPlanets()) {
					String planetName = planet.getName();
					if (planet.getMoons().size() != 0) {
						System.out.println("Mond-Namen <Planet " + planetName + "> <Monde "
								+ planet.getMoonNames() + ">");
					} else {
						System.out.println("Mond-Namen <Planet " + planetName + "> <Keine Monde vorhanden>");
						System.out.println();
					}
				}
				System.out.println();
			}
		} else if (input.equals("2")) {
			for (SolarSystem solarsystem : galaxy.getSolarSystems()) {
				System.out.println();
				System.out.println("|<-- Mond-Daten -->|");
				System.out.println();
				int count1=0;
				for (Planet planet : solarsystem.getPlanets()) {
					String planetName = planet.getName();
					int count2 = 0;
					if (planet.getMoons().size() != 0) {
						count2 = 0;
						for (Moon moon: planet.getMoons()) {
							System.out.println("|<-- Mond-Daten <"+ moon.getName()+ ">-->|");
							System.out.println();
							for (String information: moon.getInformation()) {
								System.out.println(information);
							}
							if (count2 != planet.getMoons().size() - 1) {
								System.out.println();
							}
							
							count2++;
							
						}
						if (count1 != solarsystem.getPlanets().size() - 1) {
							System.out.println();
						}
						count1++;
					} else {
						System.out.println("Mond-Daten <Planet " + planetName + "> <Keine Monde vorhanden>");
						System.out.println();
					}
				}
				System.out.println();
			}
		}
	}


	
}
