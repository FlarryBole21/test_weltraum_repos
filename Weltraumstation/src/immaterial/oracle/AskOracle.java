package immaterial.oracle;

import java.util.Scanner;

import space.Galaxy;

public abstract class AskOracle extends Oracle{
	
	public static void askUniverseInfo(Scanner scanner, Galaxy galaxy) {
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
			for(int i = 0; i< galaxy.getSolarSystemsNames().size(); i++) {
				System.out.println("Sonnensystem <"+ galaxy.getSolarSystems().get(i).getName() +">");
			}
		}
	}
	
	
	public static void askSunSystemInfo(Scanner scanner, Galaxy galaxy) {
		String input;
		System.out.println("-------------------------------------");
		System.out.println("Planten-, Sonnen- Daten einsehen?");
		System.out.print(
				"(1 -> Infos einsehen (Nur Namen), 2 -> Infos einsehen (Mehr Details), Irgendwas anderes -> Keine Infos): ");
		input = scanner.nextLine();
		System.out.println();
		if (input.equals("1")) {
			for (int i = 0; i < galaxy.getSolarSystems().size(); i++) {
				System.out.println("-- Sonnensystem <" + galaxy.getSolarSystemsNames().get(i) + "> --");
				System.out.println("Planeten-Namen <" + galaxy.getSolarSystems().get(i).getPlanetNames() + ">");
				System.out.println("Sonnen-Namen <" + galaxy.getSolarSystems().get(i).getSunNames() + ">");
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

			}

		}

	}
	
	
	public static void askMoonInfo(Scanner scanner, Galaxy galaxy) {
		String input;
		System.out.println("-------------------------------------");
		System.out.println("Mond-Daten einsehen?");
		System.out.print(
				"(1 -> Infos einsehen (Nur Namen), 2 -> Infos einsehen (Mehr Details), Irgendwas anderes -> Keine Infos): ");
		input = scanner.nextLine();
		System.out.println();
		if (input.equals("1")) {
			for (int i = 0; i < galaxy.getSolarSystems().size(); i++) {
				for (int j = 0; j < galaxy.getSolarSystems().get(i).getPlanets().size(); j++) {
					String planetName = galaxy.getSolarSystems().get(i).getPlanets().get(j).getName();
					if (galaxy.getSolarSystems().get(i).getPlanets().get(j).getMoons().size() != 0) {
						System.out.println("Mond-Namen <Planet " + planetName + "> <Monde "
								+ galaxy.getSolarSystems().get(i).getPlanets().get(j).getMoonNames() + ">");
					} else {
						System.out.println("Mond-Namen <Planet " + planetName + "> <Keine Monde vorhanden>");
					}
				}
				System.out.println();
			}
		} else if (input.equals("2")) {
			for (int i = 0; i < galaxy.getSolarSystems().size(); i++) {
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
}
