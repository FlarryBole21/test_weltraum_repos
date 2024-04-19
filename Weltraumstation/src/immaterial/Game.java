package immaterial;



import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import immaterial.oracle.AskOracle;
import immaterial.oracle.CreateOracle;
import immaterial.oracle.FileOracle;
import immaterial.oracle.ResourceOracle;
import space.Galaxy;
import space.SolarSystem;
import space.Universe;
import space.celestial.Moon;
import space.celestial.Planet;
import space.celestial.star.MainSequenceStar;

public class Game {

	public static void main(String[] args) {
		FileOracle fileOracle = new FileOracle();
		AskOracle askOracle = new AskOracle();
		CreateOracle createOracle = new CreateOracle();
		try {
			fileOracle.testFiles();
			Game game = new Game();
			game.start(fileOracle, askOracle, createOracle);
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
	
	public void start(FileOracle fileOracle, AskOracle askOracle , CreateOracle createOracle) throws RuntimeException {
		System.out.println("Willkommen in der Weltraumsimulation");
		Scanner scanner = new Scanner(System.in);
		Galaxy galaxy = createOracle.setUniverseGalaxy(scanner, fileOracle);
		createOracle.setSolar(scanner, galaxy);
		askOracle.askUniverseInfo(scanner, galaxy);
		askOracle.askSunSystemInfo(scanner, galaxy);
		askOracle.askMoonInfo(scanner, galaxy);

	}


	public void mainLoop() {

	}

	

}
