package immaterial.oracle;

import immaterial.Game;
import space.buildable.ship.BattleShip;
import space.buildable.ship.Ship;

public class ShipBattleActionOracle extends BattleActionOracle{


	private static final long serialVersionUID = 1L;
	
	private double esacpeChance;
	
	public ShipBattleActionOracle() {
		super.setType("Orakel der Schiffskampfaktionen");
		this.esacpeChance = 0.3;
	}
	

	@Override
	public void run() {
		String input;
		double randomChance;
		boolean firstRound = true;
		
		BattleShip enemyShip = createRandomEnemyShip();
		while(true) {
			if(firstRound) {
				System.out.println("Losen wer anfängt.. ");
				battleTime();
				randomChance = Math.random();
				if(randomChance < 0.5) {
					System.out.println("Feindliches Schiff darf anfangen!");
					battleInformationAll(enemyShip);
					Game.INPUTORACLE.printBreakLine();
					System.out.println("Lade nächsten Zug... ");
					battleTime();
					System.out.println("Gegner ist am Zug!");
					enemyTurn(enemyShip);
				}else {
					System.out.println("Du darfst anfangen!");
				}
				battleTime();
				Game.INPUTORACLE.printBreakLine();
				firstRound=false;
			}
			
			battleInformationAll(enemyShip);
			Game.INPUTORACLE.printBreakLine();
			System.out.println("Lade nächsten Zug... ");
			battleTime();
			System.out.println("Spieler ist am Zug!");
			System.out.println("Was möchtest du jetzt machen?");
			System.out.println("1 -> Fliehen");
			System.out.println("2 -> Angreifen");
			System.out.println("Iregndwas anderes -> Nichts");
			input = Game.INPUTORACLE.inputEmptyCheck(getScanner());
			
			if(input.equals("1")) {
				randomChance = Math.random();
				if(randomChance <= esacpeChance) {
					System.out.println("Du bist erfolgreich geflohen!");
					break;
					
				}else {
					System.err.println("Fliehen fehl geschlagen!");
				}
				
				Game.INPUTORACLE.printBreakLine();
				
			}else if (input.equals("2")) {
				 enemyShip =playerTurn(enemyShip);
			}
			
			Game.INPUTORACLE.printBreakLine();
			enemyTurn(enemyShip);
			
		}
		
	}
	
	private void battleInformationAll(BattleShip enemyShip) {
		System.out.println("Lade Informationen... ");
		battleTime();
		Game.INPUTORACLE.printBreakLine();
		System.out.println("Schiff des Spielers <Info>");
		Game.INPUTORACLE.printBreakLine();
		battleInformation((BattleShip) getGame().getPlayer().getCurrentShip());
		Game.INPUTORACLE.printBreakLine();
		System.out.println("Schiff des Gegners <Info>");
		Game.INPUTORACLE.printBreakLine();
		battleInformation(enemyShip);
		
	}
	
	private void battleInformation(BattleShip ship) {
		for(String information: ship.getInformation()) {
			System.out.println(information);
		}
		
	}
	
	
	private BattleShip playerTurn(BattleShip battleShip) {
		Game.INPUTORACLE.printBreakLine();
		BattleShip enemyShip = battleShip;
		BattleShip playerShip = (BattleShip) getGame().getPlayer().getCurrentShip();
		System.out.println("Spieler greift an!");
		int playerShipStrength = playerShip.getStrength();
		enemyShip=enemyShipTakesDamage(enemyShip,enemyShip.getHealth(), playerShipStrength);
		battleTime();
		System.out.println("Zug des Spielers beendet!");
		Game.INPUTORACLE.printBreakLine();
		return enemyShip;
	}
	
	
	private void enemyTurn(BattleShip battleShip) {
		Game.INPUTORACLE.printBreakLine();
		System.out.println("Feindliches Schiff greift an!");
		battleTime();
		int playerShipHealth = getGame().getPlayer().getCurrentShip().getHealth();
		playerShipTakesDamage(playerShipHealth, battleShip.getStrength());
		battleTime();
		System.out.println("Zug des Gegners beendet!");
		Game.INPUTORACLE.printBreakLine();
		
	}
	
	
	private void playerShipTakesDamage(int playerShipHealth, int battleShipStrength) {
		getGame().getPlayer().getCurrentShip()
		.setHealth(playerShipHealth - battleShipStrength);
		System.out.println("Schiff hat " + battleShipStrength + " Schaden erhalten");
		playerShipHealth = getGame().getPlayer().getCurrentShip().getHealth();
		System.out.println("Das Schiff des Spielers hat nur noch " + playerShipHealth + " Lebenspunkte");
		Game.INPUTORACLE.printBreakLine();
	}
	
	private BattleShip enemyShipTakesDamage(BattleShip battleShip,
			int battleShipHealth, int playerShipStrength) {
		
		BattleShip enemyShip = battleShip;
		
		enemyShip.setHealth(battleShipHealth - playerShipStrength);
		System.out.println("Feindliches Schiff hat " + playerShipStrength + " Schaden erhalten");
		System.out.println("Das Schiff des Gegners hat nur noch " + enemyShip.getHealth() + " Lebenspunkte");
		Game.INPUTORACLE.printBreakLine();
		
		return enemyShip;
	}
	
	
	private BattleShip createRandomEnemyShip() {
		int randomShipNumber = (int) (Math.random() * (5));
		BattleShip enemyShip = null;
		
		if(randomShipNumber == 0) {
			enemyShip = new BattleShip(10, 200, 100);
		}else if(randomShipNumber == 1) {
			enemyShip = new BattleShip(15, 210, 100);
		}else if (randomShipNumber == 2) {
			enemyShip = new BattleShip(20, 200, 100);
		}else if(randomShipNumber == 3) {
			enemyShip = new BattleShip(10, 210, 100);
		}else if(randomShipNumber == 4) {
			enemyShip = new BattleShip(20, 220, 100);
		}
		
		return enemyShip;
		
		
	}
	
	private void battleTime() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
	}

}
