package immaterial;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import space.Galaxy;
import space.SolarSystem;
import space.Universe;


public class Game {
	
	private final static String PLANETCREATEPATH = "data/planetCreate.txt";
	
	private Universe universe;
	public Game() {
		
	}
	
	public static void main(String[] args) {
		try {
			testFiles();
			Game game = new Game();
			game.start();
			game.mainLoop();
		}catch(FileNotFoundException e) {
			System.err.println("Error --> " + e.getMessage() + "!");
		}finally {
			System.out.println("Programm wird beendet!");
		}
		
	}
	
	
	public void start() {
		System.out.println("Willkommen in der Weltraumsimulation");
		Scanner scanner = new Scanner(System.in);
		loopSetSolar(scanner);
		
		
	}
	
	
	public void loopSetSolar(Scanner scanner) throws RuntimeException{
		String input;
		int numberInput;
		System.out.print("Bitte gebe dem Universum einen Namen: ");
		input = scanner.nextLine();
		universe = new Universe(input);
		System.out.print("Bitte gebe deiner Galaxie einen Namen: ");
		input = scanner.nextLine();
		Galaxy galaxy = universe.addGalaxy(input);
		while (true) {
			System.out.println("Wie viele Sonnensysteme möchtest du deiner Galaxie hinzufügen (MIN 1 - MAX 3)");
			input = scanner.nextLine();
			try {
				numberInput = Integer.valueOf(input);
				if(numberInput >= 1 && numberInput <= 3) {
					break;
				}else {
					System.err.println("Error --> Zahl ist zu hoch oder zu niedrig!");
				}
			}catch(RuntimeException e) {
				System.err.println("Error --> " + e.getMessage() + "!");
			}
			
		}
		for(int i = 0; i < numberInput; i++) {
			System.out.print("Bitte gebe den Namen für das " + (i+1) + ".Sonnensystem ein: ");
			input = scanner.nextLine();
			SolarSystem solarsystem = galaxy.addSolarSystem(input);
			createRandomSolarSystem(solarsystem);
		}
		System.out.println("Folgende Sonnensysteme hast du erstellt: " + galaxy.getSolarSystemsNames());
			
	}
	
	
	public void createRandomSolarSystem(SolarSystem solarsystem) {
		int randomPlanetNumber = 0;
		int randomSunNumber = 0;
		do{
			randomPlanetNumber = (int) (Math.random() * (10));
			randomSunNumber = (int) (Math.random() * (10)) - ((int) randomPlanetNumber/2);
		}while((randomSunNumber + 2) > randomPlanetNumber || randomPlanetNumber < 3 || randomSunNumber < 1);
		
		for(int i = 0; i < randomPlanetNumber; i++) {
			
		
		}
		System.out.println("Anzahl der erstellten Planten: " + randomPlanetNumber);
		System.out.println("Anzahl der erstellten Sonnen: " + randomSunNumber);
		
		
	}
	
	public void mainLoop() {
		
	}
	
	public static void testFiles() throws FileNotFoundException {
		File path = new File("./" + Game.PLANETCREATEPATH);
		if(path.exists()) {
			System.out.println("Working directory: " + path.getAbsolutePath());
		}else {
			throw new FileNotFoundException("Datei: " + "./" + Game.PLANETCREATEPATH + " wurde nicht gefunden!");
		}
		
		
	}

}
