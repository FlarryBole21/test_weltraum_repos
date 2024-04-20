package immaterial.oracle;

import java.util.Scanner;

import immaterial.Game;

public abstract class ActionOracle extends Oracle implements Runnable{

	private static final long serialVersionUID = 1L;
	private Game game;
	private Scanner scanner;
	
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
	
}
