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
	public void run() throws RuntimeException{
		testBeforeMain();
		String input;
		while(true) {
			System.out.print(
					"Was möchtest du jetzt machen? "
					+ "(1 -> Charakter-Info einsehen, "
					+ "2 -> Orts-Info einsehen, "
					+ "3 -> Planeten betreten,"
					+ "4 -> Zum anderen Planeten reisen"
					+ "5 -> Spiel beenden");
			input = Game.INPUTORACLE.inputEmptyCheck(scanner);
			if(input.equals("5")) {
			    break;
			}

		}
		
		scanner.close();
		
	}

}
