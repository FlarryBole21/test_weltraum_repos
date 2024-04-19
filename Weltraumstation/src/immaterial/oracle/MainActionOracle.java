package immaterial.oracle;

import java.util.Scanner;

import immaterial.Game;
import space.Universe;
import space.lifeform.role.Player;

public class MainActionOracle extends ActionOracle{
	
	private Game game;
	private Scanner scanner;

	public MainActionOracle() {
		super.setType("Orakel der Hauptaktionen");
	}
	
	public Scanner getScanner() {
		return scanner;
	}


	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}


	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
	
	private void testBeforeMain() throws RuntimeException{
		if(getGame() == null) {
			throw new RuntimeException("Spiel nicht gesetzt");
		}
		
		if(getGame().getGalaxy() == null) {
			throw new RuntimeException("Galaxie nicht gesetzt");
		}
		
		if(getGame().getPlayer() == null) {
			throw new RuntimeException("Spieler nicht gesetzt");
		}
		
		if(getScanner() == null) {
			throw new RuntimeException("Scanner nicht gesetzt");
		}
		
	}

	@Override
	public void run() throws RuntimeException {
		testBeforeMain();
		String input;
		Player player = getGame().getPlayer();
		while(true) {
			System.out.println("Was möchtest du jetzt machen?");
			System.out.println("0 -> Spiel beenden");
			System.out.println("1 -> Charakter-Info einsehen");
			System.out.println("2 -> Orts-Info einsehen");
			System.out.println("3 -> Anliegenden lokalen Ort betreten");
			System.out.println("4 -> Anliegenden lokalen Ort kolonisieren");
			System.out.println("5 -> Zum anderen Planeten reisen");
			input = Game.INPUTORACLE.inputEmptyCheck(scanner);
			
			if(input.equals("0")) {
			    break;
			}else if(input.equals("1")) {
			    while(true) {
			    	Game.INPUTORACLE.printBreakLineMultiple();
				    for(String information: player.getInformation()) {
				    	System.out.println(information);
				    }
				    Game.INPUTORACLE.printBreakLineMultiple();
				    boolean output = Game.ASKORACLE.returnBackToPreviousMenu(scanner);
				    if(output) {
				    	break;
				    }
			    }
			}else if(input.equals("2")) {
			    break;
			}else if(input.equals("3")) {
			    break;
			}else if(input.equals("4")) {
			    break;
			}else if(input.equals("5")) {
			    break;
			}

		}
		
		scanner.close();
		
	}

}
