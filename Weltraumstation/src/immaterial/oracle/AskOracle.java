package immaterial.oracle;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Scanner;

import immaterial.Game;
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
		Game.INPUTORACLE.printBreakLineBefore();
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
		Game.INPUTORACLE.printBreakLineAfter();
	}
	
	
	public void askSunSystemInfo(Scanner scanner, Galaxy galaxy) {
		String input;
		int count=0;
		Game.INPUTORACLE.printBreakLineBefore();
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
		Game.INPUTORACLE.printBreakLineAfter();

	}
	
	
	public void askMoonInfo(Scanner scanner, Galaxy galaxy) {
		String input;
		Game.INPUTORACLE.printBreakLineBefore();
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
		Game.INPUTORACLE.printBreakLineAfter();
		
	}
	
	
	public Planet askDestinationStart(Scanner scanner,Galaxy galaxy) {
		String input;
		Planet start = null;
		Game.INPUTORACLE.printBreakLineBefore();
		LinkedList<SolarSystem> solarsystems = galaxy.getSolarSystems();
		if(solarsystems.size() > 1) {
			System.out.println("Zu welchem Sonnensystem möchtest du reisen?");
		}
		if(solarsystems.size() == 3) {
			while (true) {
				System.out.print(
						"(1 -> " + solarsystems.get(0).getName()+", "
						+ "2 -> "+ solarsystems.get(1).getName()+", "+"3 -> "+
						solarsystems.get(2).getName()+"): ");
				input = scanner.nextLine();
				if (input.equals("1")) {
					SolarSystem solarsystem = solarsystems.get(0);
					start=checkNormalAtmosphere(solarsystem);
					break;
				}else if(input.equals("2")) {
					SolarSystem solarsystem = solarsystems.get(1);
					start=checkNormalAtmosphere(solarsystem);
					break;
					
				}else if(input.equals("3")) {
					SolarSystem solarsystem = solarsystems.get(2);
					start=checkNormalAtmosphere(solarsystem);
					break;	
				}else {
					System.err.println("Error --> Keine gültige Zahl!");
				}
			}
		}else if(solarsystems.size() == 2) {
			while (true) {
				System.out.print(
						"(1 -> " + solarsystems.get(0).getName()+", "
						+ "2 -> "+ solarsystems.get(1).getName()+"): ");
				input = scanner.nextLine();
				if (input.equals("1")) {
					SolarSystem solarsystem = solarsystems.get(0);
					start=checkNormalAtmosphere(solarsystem);
					break;
				}else if(input.equals("2")) {
					SolarSystem solarsystem = solarsystems.get(1);
					start=checkNormalAtmosphere(solarsystem);
					break;
					
				}else {
					System.err.println("Error --> Keine gültige Zahl!");
				}
			}
		}else if(solarsystems.size() == 1) {
			SolarSystem solarsystem = solarsystems.get(0);
			start=checkNormalAtmosphere(solarsystem);
		}
		Game.INPUTORACLE.printBreakLineAfter();
		return start;
	}
	
	
	private Planet checkNormalAtmosphere(SolarSystem solarSystem) {
		Planet start = null;
		Optional<Planet> planetOptional = solarSystem.getPlanets().stream()
		        .filter(planet -> planet.getAtmosphere().getType().equals("Normal"))
		        .findFirst();
		if (planetOptional.isPresent()) {
		    start = planetOptional.get(); 
		
		} else {
			throw new RuntimeException("Keine normale Atmosphäre im System vorhanden!");
		}

		return start;
		
	}
	
	public boolean returnBackToPreviousMenu(Scanner scanner) {
		String input;
		System.out.println("Zurück zum vorherigen Menü? "
    			+ "1 -> Zurück, Irgendwas anderes -> Noch nicht");
    	input = Game.INPUTORACLE.inputEmptyCheck(scanner);
    	if(input.equals("1")) {
    		return true;
    	}else {
    		return false;
    	}
	}
	


	
}
