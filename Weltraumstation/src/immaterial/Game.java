package immaterial;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import immaterial.oracle.AskOracle;
import immaterial.oracle.AsynchronOracle;
import immaterial.oracle.CreateOracle;
import immaterial.oracle.FileOracle;
import immaterial.oracle.InputOracle;
import immaterial.oracle.MainActionOracle;
import immaterial.oracle.ResourceOracle;
import space.Galaxy;
import space.celestial.Planet;
import space.lifeform.role.Player;

public class Game {
	
	public final static FileOracle FILEORACLE = new FileOracle();
	public final static AskOracle ASKORACLE = new AskOracle();
	public final static CreateOracle CREATEORACLE = new CreateOracle();
	public final static InputOracle INPUTORACLE = new InputOracle();
	public final static AsynchronOracle ASYNCHRONORACLE = new AsynchronOracle();
	public final static ResourceOracle RESOURCEORACLE = new ResourceOracle();
	public final static MainActionOracle MAINACTIONORACLE = new MainActionOracle();
	
	private Galaxy galaxy;
	private Player player;

	public static void main(String[] args) {
	
		try {
		    FILEORACLE.testFiles();
		    Game game = new Game();
		    game.start();
		    Thread.sleep(7000); 
		    INPUTORACLE.consoleClear();
		    game.mainLoop();
		} catch (FileNotFoundException e) {
		    System.err.println("FileNotFoundException --> " + e.getMessage() + "!");
		} catch (IOException e) {
		    System.err.println("IOException --> " + e.getMessage() + "!");
		} catch (NumberFormatException e) {
		    System.err.println("NumberFormatException --> " + e.getMessage() + "!");
		} catch (InterruptedException e) {
		    System.err.println("InterruptedException --> " + e.getMessage() + "!");
		    //Thread.currentThread().interrupt();
		} catch (RuntimeException e) {
		    System.err.println("RuntimeException --> " + e.getMessage() + "!");
		} catch (Exception e) {
		    System.err.println("Exception --> " + e.getMessage() + "!");
		} finally {
			INPUTORACLE.printBreakLineMultiple();
		    System.out.println("Programm wird beendet!");
		    INPUTORACLE.printBreakLineMultiple();
		}


	}
	
	public void start() throws RuntimeException {
		INPUTORACLE.printBreakLineMultiple();
		System.out.println("Willkommen in der Weltraumsimulation");
		Scanner scanner = new Scanner(System.in);
		Galaxy galaxy = CREATEORACLE.setUniverseGalaxy(scanner);
		this.galaxy=galaxy;
		CREATEORACLE.setSolar(scanner, galaxy);
		ASKORACLE.askUniverseInfo(scanner, galaxy);
		ASKORACLE.askSunSystemInfo(scanner, galaxy);
		ASKORACLE.askMoonInfo(scanner, galaxy);
		Player player = CREATEORACLE.setPlayer(scanner);
		this.player=player;
		Planet start =ASKORACLE.askDestinationStart(scanner,galaxy);
		player.setCurrentPlace(start);
		player.setCurrentSystem(start.getSolarsystem());
		INPUTORACLE.printBreakLineBefore();
		System.out.println("Du startest am Planeten <" + start.getName() 
		+ "> und im System <" + start.getSolarsystem().getName()+">");
		System.out.println("Sammle Ressourcen, Baue Schiffe & Lager, Reise von Planet zu Planet, Mond & System");
		System.out.println("und versuche zu überleben, denn du bist nicht der Einzige in dieser Welt");
		INPUTORACLE.printBreakLineMultiple();
		System.out.println("Hauptspiel wird nun gestartet... Bitte warten...");
		INPUTORACLE.printBreakLineMultiple();

		scanner.close();
		
	}


	public void mainLoop() {
		Game.INPUTORACLE.printBreakLineBefore();
		Planet planet = (Planet) player.getCurrentPlace();
		System.out.println("Hallo " + player.getName());
		System.out.println("Du befindest dich zur Zeit in einem Raumschiff <"+
		player.getCurrentShip().getType() + "> am Planeten " + planet.getName());
		System.out.println("im System "+ player.getCurrentSystem().getName());
		MAINACTIONORACLE.setGame(this);
		MAINACTIONORACLE.run();
	}
	
	public Galaxy getGalaxy() {
		return galaxy;
	}


	public Player getPlayer() {
		return player;
	}


	

}
