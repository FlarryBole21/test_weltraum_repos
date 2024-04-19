package immaterial.oracle;

import java.util.Scanner;

import immaterial.Game;
import space.lifeform.role.Player;

public class MainActionOracle extends ActionOracle{
	
	private static final long serialVersionUID = 1L;
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
			scanner = new Scanner(System.in);
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
			System.out.println("6 -> Aktuellen Fortschritt speichern");
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
				    Runnable runnable = () -> System.out.println("Zurück zum vorherigen Menü? "
				            + "1 -> Zurück, Irgendwas anderes -> Noch nicht");
				    boolean output = Game.ASKORACLE.trueFalseQuestion(scanner,runnable);
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
			}else if(input.equals("6")) {
				Game.INPUTORACLE.printBreakLineMultiple();
				Game.FILEORACLE.saveGame(scanner, game);
				Game.INPUTORACLE.printBreakLineMultiple();
			}

		}
		
		scanner.close();
		
	}

}
