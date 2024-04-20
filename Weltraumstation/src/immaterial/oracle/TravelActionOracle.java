package immaterial.oracle;

import java.util.LinkedList;
import immaterial.Game;
import space.celestial.Planet;
import space.celestial.RoundCelestial;

public class TravelActionOracle extends ActionOracle {

	private static final long serialVersionUID = 1L;
	
	public TravelActionOracle() {
		super.setType("Orakel der Reise-Aktionen");
	}
	

	@Override
	public void run() {
		testBeforeMain();
		RoundCelestial destinationCelestial = whereYouWannaGo();
		getGame().getPlayer().setCurrentPlace(destinationCelestial);
	}
	

	public RoundCelestial whereYouWannaGo() {
		String input;
		RoundCelestial destinationCelestial = null;
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
	
	
	private Planet checkPlanets() {
		LinkedList<Planet> currentPlantes = super.getGame().getPlayer().getCurrentSystem().getPlanets();
		Planet currentPlanet = (Planet) super.getGame().getPlayer().getCurrentPlace();
		Planet destinationPlanet = null;
		int index = Game.SEARCHORACLE.findIndex(currentPlantes, currentPlanet);
		if(Game.SEARCHORACLE.checkIfIndexIsPositive(index)) {
			if(index != 0 && (index != currentPlantes.size()-1)) {
				System.out.println("Zu welchem? "
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
			            +  "Irgendwas anderes -> Doch nicht");
			}else {
				System.out.println("Zu diesem Planeten reisen? "
			            + "1 -> "+ currentPlantes.get(index-1).getName() 
			            +  "Irgendwas anderes -> Doch nicht");
			}
			
		}else {
			throw new RuntimeException("Planet nicht im System vorhanden!");
		}
		
		return destinationPlanet;
	}

}
