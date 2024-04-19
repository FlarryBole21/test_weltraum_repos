package immaterial;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import immaterial.oracle.AskOracle;
import immaterial.oracle.CreateOracle;
import immaterial.oracle.FileOracle;
import immaterial.oracle.InputOracle;
import space.Galaxy;
import space.celestial.Planet;
import space.lifeform.role.Player;

public class Game {
	
	public final static FileOracle FILEORACLE = new FileOracle();
	public final static AskOracle ASKORACLE = new AskOracle();
	public final static CreateOracle CREATEORACLE = new CreateOracle();
	public final static InputOracle INPUTORACLE = new InputOracle();

	public static void main(String[] args) {
	
		try {
			FILEORACLE.testFiles();
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
		Galaxy galaxy = CREATEORACLE.setUniverseGalaxy(scanner);
		CREATEORACLE.setSolar(scanner, galaxy);
		ASKORACLE.askUniverseInfo(scanner, galaxy);
		ASKORACLE.askSunSystemInfo(scanner, galaxy);
		ASKORACLE.askMoonInfo(scanner, galaxy);
		Player player = CREATEORACLE.setPlayer(scanner);
		Planet start =ASKORACLE.askDestinationStart(scanner,galaxy);
		player.setCurrentPlace(start);
		player.setCurrentSystem(start.getSolarsystem());
		System.out.println("Du startest am Planeten <" + start.getName() 
		+ "> und im System <" + start.getSolarsystem().getName()+">");
		System.out.println("Sammle Ressourcen, Baue Schiffe & Lager, Reise von Planet zu Planet, Mond & System");
		System.out.println("und versuche zu überleben, denn du bist nicht der Einzige in dieser Welt");
		System.out.println("Hauptspiel wird nun gestartet...");
	}


	public void mainLoop() {

	}

	

}
