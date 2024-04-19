package immaterial.oracle;

import java.util.Scanner;

public class InputOracle extends Oracle{
	
	public InputOracle() {
		super.setType("Orakel der Inputs");
	}
	
	
	public String inputEmptyCheck(Scanner scanner) {
		String input;
		while(true) {
			input = scanner.nextLine();
			if(!input.isEmpty()) {
				break;
			}else {
				System.err.println("Error --> Keine Eingabe!");
			}
		}
		
		return input;
	}

}
