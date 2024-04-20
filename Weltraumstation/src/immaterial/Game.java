package immaterial;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;
import immaterial.oracle.AskOracle;
import immaterial.oracle.AsynchronOracle;
import immaterial.oracle.CreateOracle;
import immaterial.oracle.FileOracle;
import immaterial.oracle.InputOracle;
import immaterial.oracle.LocalActionOracle;
import immaterial.oracle.MainActionOracle;
import immaterial.oracle.MathOracle;
import immaterial.oracle.ResourceOracle;
import space.Galaxy;
import space.celestial.Planet;
import space.lifeform.role.Player;

public class Game implements Serializable {
	

	private static final long serialVersionUID = 1L;
	public final static FileOracle FILEORACLE = new FileOracle();
	public final static AskOracle ASKORACLE = new AskOracle();
	public final static CreateOracle CREATEORACLE = new CreateOracle();
	public final static InputOracle INPUTORACLE = new InputOracle();
	public final static AsynchronOracle ASYNCHRONORACLE = new AsynchronOracle();
	public final static ResourceOracle RESOURCEORACLE = new ResourceOracle();
	public final static MainActionOracle MAINACTIONORACLE = new MainActionOracle();
	public final static LocalActionOracle LOCALACTIONORACLE = new LocalActionOracle();
	public final static MathOracle MATHORACLE = new MathOracle();
	
	private Galaxy galaxy;
	private Player player;
	private transient Scanner scanner;

	public static void main(String[] args) {
		Game game;
		try {
		    FILEORACLE.testFiles();
		    game =FILEORACLE.loadGame();
		    if(game == null) {
		    	game = new Game();
		    	game.start();
			    FILEORACLE.saveGame(game.scanner, game);
		    }
		    INPUTORACLE.printBreakLineMultiple();
			System.out.println("Hauptspiel wird nun gestartet... Bitte warten...");
			INPUTORACLE.printBreakLineMultiple();
		    Thread.sleep(7000); 
		    INPUTORACLE.consoleClear();
		    if(game.getPlayer() != null) {
		    	if(game.getPlayer().getCurrentShip() == null) {
		    		game.mainLoop(false);
		    	}else {
		    		game.mainLoop(true);
		    	}
		    }
		} catch (FileNotFoundException e) {
		    System.err.println("FileNotFoundException --> " + e.getMessage() + "!");
		} catch (IOException e) {
		    System.err.println("IOException --> " + e.getMessage() + "!");
		} catch (NumberFormatException e) {
		    System.err.println("NumberFormatException --> " + e.getMessage() + "!");
		} 
		 catch (RuntimeException e) {
		    System.err.println("RuntimeException --> " + e.getMessage() + "!");
		} catch (Exception e) {
		    System.err.println("Exception --> " + e.getMessage() + "!");
		} finally {
			INPUTORACLE.printEndProgram();
		}


	}
	
	public void start() throws RuntimeException {
		INPUTORACLE.printBreakLineMultiple();
		System.out.println("Willkommen in der Weltraumsimulation");
		Scanner scanner = new Scanner(System.in);
		this.scanner = scanner;
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
		
	}


	public void mainLoop(boolean mainLoop) {
		if(mainLoop) {
			Game.INPUTORACLE.printBreakLineBefore();
		}
		MAINACTIONORACLE.setGame(this);
		MAINACTIONORACLE.setScanner(scanner);
		if(!mainLoop) {
			MAINACTIONORACLE.setLocalLoop(true);
		}
		MAINACTIONORACLE.run();
	}
	
	
	public Galaxy getGalaxy() {
		return galaxy;
	}


	public Player getPlayer() {
		return player;
	}


	

}
