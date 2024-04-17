package immaterial;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

import space.Galaxy;
import space.SolarSystem;
import space.Universe;
import space.celestial.star.MainSequenceStar;
import space.celestial.star.Sun;



public class Game {
	
	private final static String PLANETCREATEPATH = "data/planetCreate";
	private final static String SUNCREATEPATH = "data/sunCreate";
	private final static String MOONCREATEPATH = "data/moonCreate";
	
	
	private Universe universe;
	public Game() {
		
	}
	
	public static void main(String[] args) {
		try {
			testFiles();
			Game game = new Game();
			game.start();
			game.mainLoop();
		}catch(FileNotFoundException e) {
			System.err.println("Error --> " + e.getMessage() + "!");
		}
		catch(IOException e) {
			System.err.println("Error --> " + e.getMessage() + "!");
		}
		catch(NumberFormatException e) {
			System.err.println("Error --> " + e.getMessage() + "!");
		}
		catch(RuntimeException e) {
			System.err.println("Error --> " + e.getMessage() + "!");
		}
		catch(Exception e) {
			System.err.println("Error --> " + e.getMessage() + "!");
		}
		finally {
			System.out.println("Programm wird beendet!");
		}
		
	}
	
	
	public void start() throws RuntimeException{
		System.out.println("Willkommen in der Weltraumsimulation");
		Scanner scanner = new Scanner(System.in);
		setSolar(scanner);
		
		
	}
	
	
	public void setSolar(Scanner scanner) throws RuntimeException{
		String input;
		int numberInput;
		System.out.println("Als Erstes brauchen wir ein Universum!");
		System.out.print("Bitte gebe dem Universum einen Namen: ");
		input = scanner.nextLine();
		universe = new Universe(input);
		universe.setPlanetdata(readFile(Game.PLANETCREATEPATH+".txt"));
		universe.setSundata(readFile(Game.SUNCREATEPATH+".txt"));
		universe.setMoondata(readFile(Game.MOONCREATEPATH+".txt"));
		//System.out.println(universe.getPlanetdata());
		System.out.println("Als Zweites brauchen wir eine Galaxie!");
		System.out.print("Bitte gebe deiner Galaxie einen Namen: ");
		input = scanner.nextLine();
		Galaxy galaxy = universe.addGalaxy(input);
		System.out.println("Als Nächstes brauchen wir Sonnensysteme! (Planten, Sonnen, Monde etc. werden zufällig erstellt)");
		while (true) {
			System.out.println("Wie viele Sonnensysteme möchtest du deiner Galaxie hinzufügen ? (MIN 1 - MAX 3)");
			input = scanner.nextLine();
			try {
				numberInput = Integer.valueOf(input);
				if(numberInput >= 1 && numberInput <= 3) {
					break;
				}else {
					System.err.println("Error --> Zahl ist zu hoch oder zu niedrig!");
				}
			}catch(RuntimeException e) {
				System.err.println("Error --> " + e.getMessage() + "!");
			}
			
		}
		for(int i = 0; i < numberInput; i++) {
			System.out.print("Bitte gebe den Namen für das " + (i+1) + ".Sonnensystem ein: ");
			input = scanner.nextLine();
			SolarSystem solarsystem = galaxy.addSolarSystem(input);
			createRandomSolarSystem(solarsystem);
			//System.out.println("Folgende Planeten wurden erstellt: " + solarsystem.getPlanetNames());
		}
		
		System.out.println("Folgende Sonnensysteme hast du erstellt: " + galaxy.getSolarSystemsNames());
		System.out.print("Planten & Sonnen-Daten einsehen? (1 -> Nur Namen, "
				+ "2 -> Detailreiche Infos, Irgendwas anderes -> Keine Infos): ");
		System.out.println();
		input = scanner.nextLine();
		if(input.equals("1")) {
			for(int i = 0; i < galaxy.getSolarSystems().size(); i++) {
				System.out.println("-- Sonnensystem: " + galaxy.getSolarSystemsNames().get(i) + " --");
				System.out.println("Planeten-Namen: " + galaxy.getSolarSystems().get(i).getPlanetNames());
				System.out.println("Sonnen-Namen: " + galaxy.getSolarSystems().get(i).getSunNames());
				System.out.println();
				
			}
			
		}else if(input.equals("2")) {
			for(int i = 0; i < galaxy.getSolarSystems().size(); i++) {
				System.out.println("-- Sonnensystem: " + galaxy.getSolarSystemsNames().get(i) + " --");
				for(int j = 0; j < galaxy.getSolarSystems().get(i).getPlanets().size();j++) {
					System.out.println("Planeten-Daten: " + 
				galaxy.getSolarSystems().get(i).getPlanets().get(j).getInformation());
				}
				
				for(int k = 0; k < galaxy.getSolarSystems().get(i).getSuns().size();k++) {
					System.out.println("Sonnen-Daten: " + galaxy.getSolarSystems().get(i).getSuns().get(k).getInformation());
				}
				
				System.out.println();
				
			}
			
		}
		
		
		
	}
	
	
	public void createRandomSolarSystem(SolarSystem solarsystem) throws RuntimeException{
		int randomPlanetNumber = 0;
		int randomSunNumber = 0;
		do{
			randomPlanetNumber = (int) (Math.random() * (10));
			randomSunNumber = (int) (Math.random() * (10)) - ((int) randomPlanetNumber/2);
		}while((randomSunNumber + 2) > randomPlanetNumber || randomPlanetNumber < 3 || randomSunNumber < 1);
	
		//System.out.println(planetdata);
		for(int i = 0; i < randomPlanetNumber; i++) {
			String [] randomData;
			int randomIndex;
			int errorCount = 0;
			while(true) {
				randomIndex = (int) (Math.random() * universe.getPlanetdata().size());
				randomData = universe.getPlanetdata().get(randomIndex).split(" ");
				
				if(randomData.length > 1) {
					break;
				}else {
					errorCount++;
				}
				
				if(errorCount >= 50) {
					throw new RuntimeException("Planeten konnten nicht ordungsgemäß erstellt werden!");
				}
			}
			//System.out.println(new LinkedList<String>(Arrays.asList(randomData)));
			universe.getPlanetdata().remove(randomIndex);
			solarsystem.addPlanet(randomData[0], Double.valueOf(randomData[1]), 
					Double.valueOf(randomData[2]), Double.valueOf(randomData[3]), Double.valueOf(randomData[4]),
					universe.getAtmospheres().get((Integer.valueOf(randomData[5]))));
		
		}
		//System.out.println("Anzahl der erstellten Planten: " + randomPlanetNumber);
		
		boolean mainStar = false;
		
		for(int i = 0; i < randomSunNumber; i++) {
			String [] randomData;
			int randomIndex;
			int errorCount = 0;
			
			String starType;
			while(true) {
				if(!mainStar) {
					randomIndex = (int) (Math.random() * universe.getSundata().size());
					randomData = universe.getSundata().get(randomIndex).split(" ");
					starType=universe.getSuns().get((Integer.valueOf(randomData[5]))).getType();
					
					if(starType.equals("Hauptsequenzstern")) {
						mainStar = true;
					}
					
				}else {
					do {
						randomIndex = (int) (Math.random() * universe.getSundata().size());
						randomData = universe.getSundata().get(randomIndex).split(" ");
						starType=universe.getSuns().get((Integer.valueOf(randomData[5]))).getType();
					}while(starType.equals("Hauptsequenzstern"));
					
				}
				
				if(randomData.length > 1 && (i!= randomSunNumber-1)) {
					break;
				}else if((randomData.length > 1) && (i== randomSunNumber-1) && (mainStar)) {
					break;
				}
				else {
					errorCount++;
				}
				
				if(errorCount >= 50) {
					throw new RuntimeException("Sonnen konnten nicht ordungsgemäß erstellt werden!");
				}
			}
			//System.out.println(new LinkedList<String>(Arrays.asList(randomData)));
			universe.getSundata().remove(randomIndex);
			solarsystem.addSun(randomData[0], Double.valueOf(randomData[1]), 
					Double.valueOf(randomData[2]), Double.valueOf(randomData[3]), Double.valueOf(randomData[4]),
					universe.getSuns().get((Integer.valueOf(randomData[5]))));
			
			for(int m=0; m<solarsystem.getSuns().size();m++) {
				//System.out.println("mamorial");
				if(solarsystem.getSuns().get(m) instanceof MainSequenceStar) {
					MainSequenceStar mainstar = (MainSequenceStar) solarsystem.getSuns().get(m);
					if(mainstar.getPlanetNames().size() > 0) {
						break;
					}
					for(int n=0; n<solarsystem.getPlanets().size();n++) {
						//System.out.println("gemorial");
						mainstar.addPlanet(solarsystem.getPlanets().get(n));
					}
					
//					System.out.println("MainSequenceStar-Name: " +  mainstar.getName() +
//					" MainSequenceStar-Typ: " + mainstar.getType()+ " Planeten: "
//					+ mainstar.getPlanetNames());
					break;
					
				}
				
			}
		
		}
		
		//System.out.println("Anzahl der erstellten Sonnen: " + randomSunNumber);
		
	}
	
	public void mainLoop() {
		
	}
	
	
	public static LinkedList<String> readFile(String path) {
		LinkedList<String> rows = null;
		try {
            File datei = new File(path);
            Scanner scanner = new Scanner(datei);
            rows = new LinkedList<>();
            while (scanner.hasNextLine()) {
                rows.add(scanner.nextLine());
            }
            scanner.close();
            return rows;
        } catch (FileNotFoundException e) {
            System.out.println("Datei nicht gefunden: " + e.getMessage());
        }
		
		return rows;
	}
	
	public static void testFiles() throws IOException {
		
		File path;
		path = new File("./" + Game.PLANETCREATEPATH+".txt");
		if(!path.exists()) {
			String text = "Terra 1.0 1.0 1.0 1.0 1\n" +
		              "Draconis 0.8 0.6 0.9 0.7 0\n" +
		              "Gaia 1.2 1.2 1.1 1.1 2\n" +
		              "Aetheria 0.9 0.5 0.8 0.6 1\n" +
		              "Novaria 1.1 1.3 1.2 1.2 1\n" +
		              "Vulcan 0.7 0.4 0.6 0.5 0\n" +
		              "Eden 1.3 1.5 1.3 1.3 2\n" +
		              "Oasis 1.0 0.9 1.0 0.9 1\n" +
		              "Inferno 0.6 0.3 0.5 0.4 0\n" +
		              "Aurora 1.2 1.1 1.1 1.1 0\n" +
		              "Celestia 0.8 0.7 0.9 0.7 1\n" +
		              "Serenity 1.0 0.8 0.9 0.8 0\n" +
		              "Titan 0.9 0.6 0.8 0.6 1\n" +
		              "Zephyr 1.1 1.0 1.1 1.0 2\n" +
		              "Infernum 0.7 0.5 0.6 0.5 2\n" +
		              "Seraphim 1.3 1.2 1.2 1.1 2\n" +
		              "Phoenix 0.8 0.6 0.8 0.6 0\n" +
		              "Elysium 1.2 1.1 1.1 1.1 0\n" +
		              "Nemesis 0.9 0.7 0.9 0.7 0\n" +
		              "Halcyon 1.1 0.9 1.0 0.9 1\n" +
		              "Helios 0.7 0.4 0.6 0.4 1\n" +
		              "Arcadia 1.2 1.0 1.1 1.0 1\n" +
		              "Abyss 0.8 0.5 0.7 0.5 1\n" +
		              "Zenith 1.1 0.9 1.0 0.9 2\n" +
		              "Aeolus 1.2 1.1 1.1 1.0 2\n" +
		              "Hades 0.8 0.6 0.7 0.6 0\n" +
		              "Utopia 1.1 1.0 1.1 1.0 2\n" +
		              "Olympus 0.7 0.4 0.6 0.4 1\n";

			
			createFileAndWrite(path, text);
			//throw new FileNotFoundException("Datei: " + "./" + Game.PLANETCREATEPATH + " wurde nicht gefunden!");
		}
		path = new File("./" + Game.SUNCREATEPATH+".txt");
		if(!path.exists()) {
			String text = "Sol 1.0 1.0 5778 1.0 4\n" +
	                "Sirius 2.0 1.5 9940 23.6 1\n" +
	                "Proxima 0.12 0.15 3042 0.0017 3\n" +
	                "Alpha 1.5 2.0 10370 80.4 0\n" +
	                "Betelgeuse 20.0 1.0 3130 120000 5\n" +
	                "Vega 2.1 2.7 9602 40.1 2\n" +
	                "Pollux 1.9 8.8 4736 36.0 4\n" +
	                "Arcturus 1.1 25.4 4290 170.0 2\n" +
	                "Deneb 19.0 203.0 8520 196000 1\n" +
	                "Regulus 3.5 3.8 12100 288.0 5\n" +
	                "Antares 15.0 680.0 3590 64000 0\n" +
	                "Rigel 23.0 78.9 12100 120000 3\n" +
	                "Aldebaran 1.1 44.2 3910 400.0 1\n" +
	                "Spica 10.0 7.0 22400 2140.0 0\n" +
	                "Bellatrix 6.0 4.0 22000 800.0 0\n" +
                    "Polaris 5.5 45.0 5800 430.0 0\n" +
                    "Fomalhaut 1.8 1.6 8600 17.9 0\n" +
                    "Achernar 6.2 11.0 15000 850.0 0\n" +
                    "Alnilam 40.0 20.0 27900 375000 0\n" +
					"Alkaid 2.0 3.0 14000 45.0 1\n" +
		            "Denebola 2.8 2.2 11000 16.0 1\n" +
		            "Mirfak 5.0 5.0 6200 500.0 1\n" +
		            "Wezen 40.0 25.0 18000 140000 1\n" +
		            "Alphard 7.5 2.0 24000 400.0 1\n"+
		            "Alcyone 4.0 4.0 8000 250.0 0\n" +
                    "Mirach 3.0 5.0 9000 220.0 0\n" +
                    "Hamal 2.5 2.0 6700 40.0 0\n" +
                    "Menkar 5.0 7.0 5200 550.0 0\n" +
                    "Mirzam 15.0 10.0 18700 14000 0\n";
			createFileAndWrite(path, text);
			//throw new FileNotFoundException("Datei: " + "./" + Game.SUNCREATEPATH + " wurde nicht gefunden!");
		}
		path = new File("./" + Game.MOONCREATEPATH+".txt");
		if(!path.exists()) {
			String text = "Luna 1.0 1.0 1.0 1.0 1\n" +
		              "Phobos 0.8 0.6 0.9 0.7 0\n" +
		              "Ganymede 1.2 1.2 1.1 1.1 2\n" +
		              "Deimos 0.7 0.4 0.6 0.5 0\n" +
		              "Io 1.3 1.5 1.3 1.3 2\n" +
		              "Callisto 1.0 0.9 1.0 0.9 1\n" +
		              "Enceladus 0.6 0.3 0.5 0.4 0\n" +
		              "Triton 1.2 1.1 1.1 1.1 0\n" +
		              "Charon 0.8 0.7 0.9 0.7 1\n" +
		              "Phoebe 1.0 0.8 0.9 0.8 0\n" +
		              "Rhea 0.9 0.6 0.8 0.6 1\n" +
		              "Lapetus 1.1 1.0 1.1 1.0 2\n" +
		              "Miranda 0.7 0.5 0.6 0.5 2\n" +
		              "Titania 1.3 1.2 1.2 1.1 2\n" +
		              "Umbriel 0.8 0.6 0.7 0.6 0\n" +
		              "Dione 1.1 1.0 1.1 1.0 2\n" +
		              "Ariel 0.7 0.4 0.6 0.4 1\n" +
		              "Proteus 1.2 1.0 1.1 1.0 1\n" +
		              "Nereid 0.8 0.5 0.7 0.5 1\n" +
		              "Oberon 1.1 0.9 1.0 0.9 2\n" +
		              "Charon 1.2 1.1 1.1 1.0 2\n" +
		              "Puck 0.8 0.6 0.7 0.6 0\n" +
		              "Caliban 1.1 1.0 1.1 1.0 2\n" +
		              "Sycorax 0.7 0.4 0.6 0.4 1\n" +
		              "Hyperion 1.0 1.0 1.0 1.0 1\n" +
		              "Amalthea 0.8 0.6 0.9 0.7 0\n" +
		              "Mimas 1.2 1.2 1.1 1.1 2\n" +
		              "Tethys 0.9 0.5 0.8 0.6 1\n" +
		              "Thebe 1.1 1.3 1.2 1.2 1\n" +
		              "Rhea 0.7 0.4 0.6 0.5 0\n" +
		              "Miranda 1.3 1.5 1.3 1.3 2\n" +
		              "Callirrhoe 1.0 0.9 1.0 0.9 1\n" +
		              "Paaliaq 0.6 0.3 0.5 0.4 0\n" +
		              "Ymir 1.2 1.1 1.1 1.1 0\n" +
		              "Carme 0.8 0.7 0.9 0.7 1\n" +
		              "Ananke 1.0 0.8 0.9 0.8 0\n" +
		              "Kalyke 0.9 0.6 0.8 0.6 1\n" +
		              "Orthosie 1.1 1.0 1.1 1.0 2\n" +
		              "Herse 0.7 0.5 0.6 0.5 2\n" +
		              "Aitne 1.3 1.2 1.2 1.1 2\n" +
		              "Eurydome 0.8 0.6 0.7 0.6 0\n" +
		              "Autonoe 1.1 1.0 1.1 1.0 2\n" +
		              "Thyone 0.7 0.4 0.6 0.4 1\n" +
		              "Hermippe 1.2 1.1 1.1 1.0 1\n" +
		              "Aedea 0.8 0.5 0.7 0.5 1\n" +
		              "Euanthe 1.1 0.9 1.0 0.9 2\n" +
		              "Helike 0.7 0.4 0.6 0.4 1\n" +
		              "Orthosie 1.2 1.0 1.1 1.0 1\n" +
		              "Hegemone 0.8 0.6 0.7 0.6 1\n" +
		              "Philophrosyne 1.1 1.0 1.1 1.0 2\n" +
		              "Dia 0.7 0.4 0.6 0.4 1\n" +
		              "Sponde 1.2 1.0 1.1 1.0 1\n" +
		              "Kale 0.8 0.5 0.7 0.5 1\n" +
		              "Pasithee 1.1 0.9 1.0 0.9 2\n" +
		              "Megaclite 0.7 0.4 0.6 0.4 1\n";

			createFileAndWrite(path, text);
			//throw new FileNotFoundException("Datei: " + "./" + Game.SUNCREATEPATH + " wurde nicht gefunden!");
		}
		
		
	}
	
	public static void createFileAndWrite(File path, String text) throws IOException{
		path.createNewFile();
		FileWriter writer = new FileWriter(path);
        writer.write(text);
        writer.close();
		
	}
	

}
