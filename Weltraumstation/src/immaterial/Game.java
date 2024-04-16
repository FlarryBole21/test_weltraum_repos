package immaterial;

import java.util.Scanner;

import space.Galaxy;
import space.SolarSystem;
import space.Universe;

public class Game {
	
	public Game() {
		
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.start();
		try {
			game.mainLoop();
		} catch (RuntimeException e) {
			System.err.println("Error --> " + e.getMessage());
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
		System.out.println("Bitte gebe dem Universum einen Namen");
		input = scanner.nextLine();
		Universe universe = new Universe(input);
		System.out.println("Bitte gebe deiner Galaxie einen Namen");
		input = scanner.nextLine();
		Galaxy galaxy = universe.addGalaxy(input);
		while (true) {
			System.out.println("Wie viele Sonnensysteme möchtest du deiner Galaxie hinzufügen (MIN 1 - MAX 3)");
			input = scanner.nextLine();
			try {
				numberInput = Integer.valueOf(input);
				break;
			}catch(RuntimeException e) {
				System.out.println("Error --> " + e.getMessage());
			}
			
		}
		System.out.println(input);
		for(int i = 0; i < numberInput; i++) {
			input = scanner.nextLine();
			galaxy.addSolarSystem(input);
		}
		
	}
	
	public void mainLoop() {
		
	}

}
