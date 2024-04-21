package immaterial.oracle;

import java.util.function.Consumer;
import immaterial.Game;
import space.celestial.Moon;
import space.celestial.Planet;
import space.celestial.RoundCelestial;
import space.lifeform.role.Player;

public class MainActionOracle extends ActionOracle{
	
	private static final long serialVersionUID = 1L;
	private boolean localLoop;

	public MainActionOracle() {
		super.setType("Orakel der Hauptaktionen");
	}
	
	public boolean getLocalLoop() {
		return localLoop;
	}

	public void setLocalLoop(boolean localLoop) {
		this.localLoop = localLoop;
	}

	@Override
	public void run() throws RuntimeException {
		testBeforeMain();
		String input;
		Player player = getGame().getPlayer();
		while(true) {
			checkPlayerHealth();
			if(!getLocalLoop()) {
				Planet planet = (Planet) player.getCurrentPlace();
				System.out.println("Hallo " + player.getName());
				System.out.println("Du befindest dich zur Zeit in einem Raumschiff <"+
				player.getCurrentShip().getType() + "> am Ort " + planet.getType()+ " <"+ planet.getName()+">");
				System.out.println("im System <"+ player.getCurrentSystem().getName()+">");
				Game.INPUTORACLE.printBreakLine();
				
				System.out.println("Was möchtest du jetzt machen?");
				System.out.println("0 -> Spiel beenden");
				System.out.println("1 -> Charakter-Info einsehen");
				System.out.println("2 -> Orts-Info einsehen");
				System.out.println("3 -> Schifs-Info einsehen");
				System.out.println("4 -> Anliegenden lokalen Ort betreten");
				System.out.println("5 -> Anliegenden lokalen Ort kolonisieren");
				System.out.println("6 -> Zum einem anderen Ort reisen");
				System.out.println("7 -> Aktuellen Fortschritt speichern");
				input = Game.INPUTORACLE.inputEmptyCheck(getScanner());
			}else {
				input = "4";
			}
			
			if(input.equals("0")) {
			    break;
			}else if(input.equals("1")) {
				Runnable runnable = ()->{
					for(String information: player.getInformation()) {
				    	System.out.println(information);
				    }
				};
				subMenu(runnable,true); 
			}else if(input.equals("2")) {
				Runnable runnable = ()->{
					if(player.getVisitedPlanets().contains(player.getCurrentPlace()) 
							|| player.getVisitedMoons().contains(player.getCurrentPlace())) {
						
						Consumer<RoundCelestial> roundConsumer = (round) -> {
							for(String information: round.getInformation()) {
						    	System.out.println(information);
						    }
				        };
				        
				        roundConsumer.accept(player.getCurrentPlace());
						
					}else {
						System.err.println("Error --> Ort noch nicht besucht!");
						System.err.println("Nur Informationen über bereits besuchte Orte können abgefragt werden!");
						System.err.println("Rufe über das Hauptmenü die Charakter-Info auf, um zu sehen,");
						System.err.println("welche Orte du schon bereits besucht hast!");
						Game.INPUTORACLE.printBreakLineMultiple();
					}
		
				};
				subMenu(runnable,true); 
			}else if(input.equals("3")) {
				Runnable runnable = ()->{
					if(player.getCurrentShip() != null) {
						for(String information: player.getCurrentShip().getInformation()) {
					    	System.out.println(information);
					    }
						
					}else if(player.getShipParked() != null) {
						for(String information: player.getShipParked().getInformation()) {
					    	System.out.println(information);
					    }
					}else {
						System.err.println("Schiffs-Informationen konnten nicht geladen werden!");
						Game.INPUTORACLE.printBreakLine();
					}
					
				};
				subMenu(runnable,true); 
			}else if(input.equals("4")) {
				Runnable runnable;
				
				if(getLocalLoop()) {
					runnable = ()->localLoop();
				}else {
					runnable = ()->{
						
						Consumer<RoundCelestial> roundConsumer = (round) -> {
							if((!player.getCurrentPlace().getAtmosphere().getType().equals("Normal")) &&
									player.getCurrentSuit().getType().equals("Weltraumwanderer-Anzug")) {
								System.err.println("Warnung! " + "Die Atmosphäre ist " + round.getAtmosphere().getType() 
										+ " und du hast nur einen " + player.getCurrentSuit().getType()+ " an!");
								System.err.println("Es könnten ungewünschte Effekte auftreten!");
								enterLocalPlace(true);
								
							}else {
								enterLocalPlace(false);
							}
				        };
				
				        roundConsumer.accept(player.getCurrentPlace());
					};	
				}	
				subMenu(runnable,false); 
			}else if(input.equals("5")) {
			    break;
			}else if(input.equals("6")) {
				Runnable runnable = () -> {
					if(player.getCurrentPlace() instanceof Planet) {
						Planet planet = (Planet) player.getCurrentPlace();
						if(planet.getMoons().size() > 0) {
							Game.TRAVELACTIONORACLE.checkAndRun(Game.TRAVELACTIONORACLE,getGame(),getScanner());
						}else {
							Game.TRAVELACTIONORACLE.checkAndRun(Game.TRAVELACTIONORACLE,getGame(),getScanner());
						}
					}else if(player.getCurrentPlace() instanceof Moon) {
						Moon moon = (Moon) player.getCurrentPlace();
						Game.TRAVELACTIONORACLE.checkAndRun(Game.TRAVELACTIONORACLE,getGame(),getScanner());
					}
				};
				
				
				subMenu(runnable,true); 
			}else if(input.equals("7")) {
				Game.INPUTORACLE.printBreakLineMultiple();
				Game.FILEORACLE.saveGame(getScanner(), getGame());
				Game.INPUTORACLE.printBreakLineMultiple();
			}else {
				Game.INPUTORACLE.printBreakLineMultiple();
				System.err.println("Error --> Ungültige Eingabe!");
				Game.INPUTORACLE.printBreakLineMultiple();
			}

		}
		
		super.getScanner().close();
		
	}
	
	

	private void enterLocalPlace(boolean askEnter) {
		String input="1";
		if(askEnter) {
			System.out.println("Möchtest du diesen Planeten wirklich betreten?");
			System.out.print(
					"(1 -> Ja, Irgendwas anderes -> Nein): ");
			input = Game.INPUTORACLE.inputEmptyCheck(getScanner());
		}
		if(input.equals("1")) {
			getGame().getPlayer().addVisited(getGame().getPlayer().getCurrentPlace());
			getGame().getPlayer().leaveShip();
			Game.INPUTORACLE.printBreakLineMultiple();
			System.out.println("Du bist aus deinem Raumschiff ausgestiegen...");
			localLoop();
			
		}
		
	}

	private void localLoop() {
		if(!getLocalLoop()) {
			Game.INPUTORACLE.printBreakLineMultiple();
		}
		Game.MAINACTIONORACLE.setLocalLoop(true);
		Game.LOCALACTIONORACLE.checkAndRun(Game.LOCALACTIONORACLE,getGame(),getScanner());
	}
	
	
	public void subMenu(Runnable runnable, boolean askBack) {
		boolean output;
		 while(true) {
		    	Game.INPUTORACLE.printBreakLineMultiple();
			    runnable.run();
			    if(askBack) {
			    	 output = backToMainMenu();
			    }else {
			    	break;
			    }
			    if(output) {
			    	break;
			    }
		    }
	}
	
	public void checkPlayerHealth() {
		if(getGame().getPlayer().getHealth() <= 0) {
			Game.INPUTORACLE.printBreakLineMultiple();
			System.out.println("Spieler " + getGame().getPlayer().getName() + " ist gestorben!");
			Game.INPUTORACLE.printEndProgram();
		}
	}
	
	
	private boolean backToMainMenu() {
		
		Game.INPUTORACLE.printBreakLineMultiple();
	    Runnable runnable = () -> System.out.println("Zurück zum Haupt-Menü? "
	            + "1 -> Zurück, Irgendwas anderes -> Noch nicht");
	    boolean output = Game.ASKORACLE.trueFalseQuestion(getScanner(),runnable);
	    return output;
		
	}
	

}
