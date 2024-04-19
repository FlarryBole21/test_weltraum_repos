package immaterial.oracle;

import java.util.Scanner;

import immaterial.Game;
import space.Universe;
import space.lifeform.role.Player;

public class MainActionOracle extends ActionOracle{
	
	private Game game;
	
	public MainActionOracle() {
		super.setType("Orakel der Hauptaktionen");
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
		
	}

	@Override
	public void run() throws RuntimeException{
		testBeforeMain();
		
	}

}
