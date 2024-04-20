package immaterial.oracle;

import java.util.Scanner;
import java.util.function.Consumer;

import immaterial.Game;
import space.celestial.Planet;
import space.celestial.RoundCelestial;
import space.lifeform.role.Player;

public class LocalActionOracle extends ActionOracle{

	private static final long serialVersionUID = 1L;

	public LocalActionOracle() {
		super.setType("Orakel der lokalen Aktionen");
	}
	
	private void testBeforeMain() throws RuntimeException{
		if(super.getGame() == null) {
			throw new RuntimeException("Spiel nicht gesetzt");
		}
		
		if(super.getGame().getGalaxy() == null) {
			throw new RuntimeException("Galaxie nicht gesetzt");
		}
		
		if(super.getGame().getPlayer() == null) {
			throw new RuntimeException("Spieler nicht gesetzt");
		}
		
		if(super.getScanner() == null) {
			Scanner scanner = new Scanner(System.in);
			super.setScanner(scanner);
		}
		
	}

	@Override
	public void run() throws RuntimeException{
		testBeforeMain();
		Planet planet = (Planet) super.getGame().getPlayer().getCurrentPlace();
		System.out.println("Du befindest dich zur Zeit in keinem Raumschiff am Ort " 
		+ planet.getType()+ " <"+ planet.getName()+">");
		System.out.println("im System <"+ super.getGame().getPlayer().getCurrentSystem().getName()+">");
		String input;
		Player player = getGame().getPlayer();
		Game.INPUTORACLE.printBreakLineMultiple();
		while(true) {
			System.out.println("Was möchtest du jetzt machen?");
			System.out.println("0 -> Spiel beenden");
			System.out.println("1 -> Charakter-Info einsehen");
			System.out.println("2 -> Orts-Info einsehen");
			System.out.println("3 -> Zurück zum Raumschiff");
			System.out.println("4 -> Aktuellen Fortschritt speichern");
			input = Game.INPUTORACLE.inputEmptyCheck(super.getScanner());
			
			if(input.equals("0")) {
				Game.INPUTORACLE.printEndProgram();
				System.exit(0);
			}else if(input.equals("1")) {
				Runnable runnable = ()->{
					for(String information: player.getInformation()) {
				    	System.out.println(information);
				    }
				};
				Game.MAINACTIONORACLE.subMenu(runnable, true);
				Game.INPUTORACLE.printBreakLineMultiple();
			
			}else if(input.equals("2")) {
				Runnable runnable = ()->{
					Consumer<RoundCelestial> roundConsumer = (round) -> {
						for(String information: round.getInformation()) {
					    	System.out.println(information);
					    }
			        };
			        
			        roundConsumer.accept(player.getCurrentPlace());
				};
				
				Game.MAINACTIONORACLE.subMenu(runnable, true);
		        Game.INPUTORACLE.printBreakLineMultiple();
			}else if(input.equals("3")) {
				Game.MAINACTIONORACLE.setLocalLoop(false);
				player.enterShip();
				System.out.println("Du steigst wieder in dein Raumschiff ein...");
				Game.INPUTORACLE.printBreakLineMultiple();
				break;
				
			}else if(input.equals("4")) {
				Game.INPUTORACLE.printBreakLineMultiple();
				Game.FILEORACLE.saveGame(super.getScanner(), super.getGame());
				Game.INPUTORACLE.printBreakLineMultiple();
				
			}else {
				Game.INPUTORACLE.printBreakLineMultiple();
				System.err.println("Error --> Ungültige Eingabe!");
				Game.INPUTORACLE.printBreakLineMultiple();
			}

		}
		
		
		
	}
}


