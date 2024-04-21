package immaterial.oracle;

import java.util.function.Consumer;
import java.util.function.Predicate;

import immaterial.Game;
import space.celestial.Planet;
import space.celestial.RoundCelestial;
import space.environment.atmosphere.Atmosphere;
import space.lifeform.role.Player;

public class LocalActionOracle extends ActionOracle{

	private static final long serialVersionUID = 1L;

	public LocalActionOracle() {
		super.setType("Orakel der lokalen Aktionen");
	}
	
	//Subschleife des Spiels
	//Der Spieler wird gefragt welche Option er wählen möchte
	//Spieler befindet sich hier NICHT im Raumschiff und ist auf einem Planeten / Mond
	//Von hier aus kann man aber wieder zurück ins Hauptmenü --> Spieler kann wieder in sein Schiff steigen
	//Reisen ist hier nicht möglich
	@Override
	public void run() throws RuntimeException{
		testBeforeMain();
		Planet planet = (Planet) getGame().getPlayer().getCurrentPlace();
		String input;
		Player player = getGame().getPlayer();
		while(true) {
			System.out.println("Du befindest dich zur Zeit in keinem Raumschiff am Ort " 
			+ planet.getType()+ " <"+ planet.getName()+">");
			System.out.println("im System <"+ getGame().getPlayer().getCurrentSystem().getName()+">");
			testAtmoToPlayer(); 
			Game.MAINACTIONORACLE.checkPlayerHealth();
			Game.INPUTORACLE.printBreakLine();
			System.out.println("Was möchtest du jetzt machen?");
			System.out.println("0 -> Spiel beenden");
			System.out.println("1 -> Charakter-Info einsehen");
			System.out.println("2 -> Orts-Info einsehen");
			System.out.println("3 -> Zurück zum Raumschiff");
			System.out.println("4 -> Aktuellen Fortschritt speichern");
			input = Game.INPUTORACLE.inputEmptyCheck(getScanner());
			
			if(input.equals("0")) {
				Game.INPUTORACLE.printEndProgram();
				System.exit(0);
			}else if(input.equals("1")) {
				//Charakter-Informationen -> Siehe Hauptmenü
				Runnable runnable = ()->{
					for(String information: player.getInformation()) {
				    	System.out.println(information);
				    }
				};
				Game.MAINACTIONORACLE.subMenu(runnable, true);
				Game.INPUTORACLE.printBreakLineMultiple();
			
			}else if(input.equals("2")) {
				//Orts-Informationen -> Siehe Hauptmenü
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
				//Spieler steigt wieder in sein Schiff ein -> Rückkehr ins Hauptmenü
				Game.MAINACTIONORACLE.setLocalLoop(false);
				player.enterShip();
				Game.INPUTORACLE.printBreakLineMultiple();
				System.out.println("Du steigst wieder in dein Raumschiff ein...");
				Game.INPUTORACLE.printBreakLineMultiple();
				break;
				
			}else if(input.equals("4")) {
				//Speichern
				Game.INPUTORACLE.printBreakLineMultiple();
				Game.FILEORACLE.saveGame(getScanner(), getGame());
				Game.INPUTORACLE.printBreakLineMultiple();
				
			}else {
				Game.INPUTORACLE.printBreakLineMultiple();
				System.err.println("Error --> Ungültige Eingabe!");
				Game.INPUTORACLE.printBreakLineMultiple();
			}

		}
		
		
		
	}
	
	//Bei jedem mal, wenn man den Ort betritt oder wenn man nach der Auswahl einer Option wieder ins Submenü zurückkehrt
	//wird geprüft ob der Spieler einen normalen Anzug anhat und ob die Atmosphäre normal ist
	//Wenn er beispielsweise nur einen normalen Anzug anhat und in einer toxischen Atmospähre ist --> Spieler bekommt Schaden
	private void testAtmoToPlayer() {
		
		Atmosphere atmosphere = getGame().getPlayer().getCurrentPlace().getAtmosphere();
		
		Predicate<String> normalSuit = (check) ->{
			return check.equals("Weltraumwanderer-Anzug");
		};
		
		Boolean checked = normalSuit.test(getGame().getPlayer().getCurrentSuit().getType());
		
		atmosphere.inhale(checked, getGame().getPlayer());
		
	}
}


