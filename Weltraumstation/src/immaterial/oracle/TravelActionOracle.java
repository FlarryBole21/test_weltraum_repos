package immaterial.oracle;

import java.util.LinkedList;
import immaterial.Game;
import space.celestial.Planet;
import space.celestial.RoundCelestial;

public class TravelActionOracle extends ActionOracle {

	private static final long serialVersionUID = 1L;
	
	private int round;
	private int maxRound;
	private double battleChance;
	
	public TravelActionOracle() {
		super.setType("Orakel der Reise-Aktionen");
		this.round=3;
		this.maxRound = round;
		this.battleChance=0.4;
	}
	
	
	public boolean removeRound() {
		if(round > 0) {
			this.round -= 1;
			return true;
		}else {
			return false;
		}
	}
	

	@Override
	public void run() {
		testBeforeMain();
		RoundCelestial destinationCelestial = whereYouWannaGo();
		boolean travelOutput = travelPhase(destinationCelestial);
		if(travelOutput) {
			System.out.println("Du hast die Fahrt überstanden!");
			getGame().getPlayer().setCurrentPlace(destinationCelestial);
			Game.INPUTORACLE.printBreakLineMultiple();
			System.out.println("Du bist jetzt in " + destinationCelestial.getType() 
			+ " <" + destinationCelestial.getName()+">");
			
		}else {
			System.err.println("Dein Schiff wurde zerstört");
			System.err.println("Fahrt fehlgeschlagen!");
			System.err.println("Du hast die Fahrt nicht überlebt und bist nun tot!");
			Game.INPUTORACLE.printBreakLineMultiple();
			getGame().getPlayer().setHealth(0);
			Game.MAINACTIONORACLE.checkPlayerHealth();
			Game.INPUTORACLE.printBreakLineMultiple();
		}
	}
	

	private RoundCelestial whereYouWannaGo() {
		String input;
		RoundCelestial destinationCelestial = null;
		System.out.println("Du kannst nur zur sich in der Nähe befindenen Planeten & Monden");
		System.out.println("Reisen? "
	            + "1 -> Planet, 2 -> Mond,  Irgendwas anderes -> Doch nicht");
		while(true) {
			input = Game.INPUTORACLE.inputEmptyCheck(super.getScanner());
			if(input.equals("1")) {
				destinationCelestial =checkPlanets();
				return destinationCelestial;
				
			}else if (input.equals("2")) {
				
				break;
				
			}else {
				break;
			}
			
		}
		
		return destinationCelestial;
	}
	
	private boolean travelPhase(RoundCelestial destination){
		
		double randomChance;
		
		System.out.println("Du bist nun unterwegs nach " 
		+ destination.getType() + " <" + destination.getName() + ">");
		System.out.println("Dieser Prozess nimmt jedoch etwas Zeit in Anspruch.");
		System.out.println("Hoffentlich läuft alles gut!");
		
		while(true) {
			System.out.println("Du befindest dich nun in Runde " + (round+1) + "/" + (maxRound+1));
			randomChance = Math.random();
			 if (randomChance <= battleChance) {
				 System.out.println("Du fährst eine Runde...");
				 travelTime();
	             System.out.println("Ein gegnerisches Schiff nährt sich!");
	             travelTime();
	             Game.INPUTORACLE.printBreakLine();
	             System.out.println("Betrete Kampf-Phase");
	             travelTime();
	             Game.INPUTORACLE.printBreakLine();
	             Game.SHIPBATTLEACTIONORACLE.checkAndRun(Game.SHIPBATTLEACTIONORACLE,getGame(),getScanner());
	             
	        } else {
	     
	            System.out.println("Du fährst eine Runde...");
	            travelTime();
	            System.out.println("Nichts passiert!");
	            travelTime();
	            Game.INPUTORACLE.printBreakLine();
	        }
			 
			if(removeRound()) {
				System.out.println("Runde beendet!");
				travelTime();
				Game.INPUTORACLE.printBreakLine();
				
			}else {
				System.out.println("Runde beendet!");
				travelTime();
				Game.INPUTORACLE.printBreakLine();
				break;
			}
		}
		
		if(getGame().getPlayer().getCurrentShip().getHealth() == 0) {
			return false;
		}
		
		return true;
		
	}
	
	
	private Planet checkPlanets() {
		LinkedList<Planet> currentPlantes = super.getGame().getPlayer().getCurrentSystem().getPlanets();
		Planet currentPlanet = (Planet) super.getGame().getPlayer().getCurrentPlace();
		Planet destinationPlanet = null;
		int index = Game.SEARCHORACLE.findIndex(currentPlantes, currentPlanet);
		if(Game.SEARCHORACLE.checkIfIndexIsPositive(index)) {
			if(index != 0 && (index != currentPlantes.size()-1)) {
				System.out.println("Planten in der Nähe wurden geprüft...");
				System.out.println("Zu welchem Reisen? "
			            + "1 -> "+ currentPlantes.get(index-1).getName() 
			            + ", 2 -> "+ currentPlantes.get(index+1).getName()+",  Irgendwas anderes -> Doch nicht");
				while(true) {
					String input = Game.INPUTORACLE.inputEmptyCheck(super.getScanner());
					if(input.equals("1")) {
						destinationPlanet =currentPlantes.get(index-1);
						break;
					}else if (input.equals("2")) {
						destinationPlanet =currentPlantes.get(index+1);
						break;
					}else {
						break;
					}
				}
				
			}else if( index == 0) {
				System.out.println("Zu diesem Planeten reisen? "
			            + "1 -> "+ currentPlantes.get(index+1).getName() 
			            +  ", Irgendwas anderes -> Doch nicht");
				while(true) {
					String input = Game.INPUTORACLE.inputEmptyCheck(super.getScanner());
					if(input.equals("1")) {
						destinationPlanet =currentPlantes.get(index+1);
						break;
					}else {
						break;
					}
				}
			}else {
				System.out.println("Zu diesem Planeten reisen? "
			            + "1 -> "+ currentPlantes.get(index-1).getName() 
			            +  "Irgendwas anderes -> Doch nicht");
				while(true) {
					String input = Game.INPUTORACLE.inputEmptyCheck(super.getScanner());
					if(input.equals("1")) {
						destinationPlanet =currentPlantes.get(index-1);
						break;
					}else {
						break;
					}
				}
			}
			
		}else {
			throw new RuntimeException("Planet nicht im System vorhanden!");
		}
		
		return destinationPlanet;
	}
	
	
	private void travelTime() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}

}
