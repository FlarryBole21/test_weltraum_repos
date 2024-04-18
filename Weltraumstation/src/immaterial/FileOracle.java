package immaterial;

public abstract class FileOracle extends Oracle{

	private final static String PLANETDATA = "Terra 1.0 1.0 1.0 1 7\n" + "Draconis 0.8 0.6 0.7 0 3\n"
			+ "Gaia 1.2 1.2 1.1 2 9\n" + "Aetheria 0.9 0.5 0.6 1 5\n" + "Novaria 1.1 1.3 1.2 1 8\n"
			+ "Vulcan 0.7 0.4 0.5 0 2\n" + "Eden 1.3 1.5 1.3 2 6\n" + "Oasis 1.0 0.9 0.9 1 4\n"
			+ "Inferno 0.6 0.3 0.4 0 7\n" + "Aurora 1.2 1.1 1.1 0 9\n" + "Celestia 0.8 0.7 0.7 1 1\n"
			+ "Serenity 1.0 0.8 0.8 0 6\n" + "Titan 0.9 0.6 0.6 1 3\n" + "Zephyr 1.1 1.0 1.0 2 8\n"
			+ "Infernum 0.7 0.5 0.5 2 4\n" + "Seraphim 1.3 1.2 1.1 2 5\n" + "Phoenix 0.8 0.6 0.6 0 7\n"
			+ "Elysium 1.2 1.1 1.1 0 2\n" + "Nemesis 0.9 0.7 0.7 0 8\n" + "Halcyon 1.1 0.9 0.9 1 1\n"
			+ "Helios 0.7 0.4 0.4 1 3\n" + "Arcadia 1.2 1.0 1.0 1 9\n" + "Abyss 0.8 0.5 0.5 1 6\n"
			+ "Zenith 1.1 0.9 0.9 2 4\n" + "Aeolus 1.2 1.1 1.0 2 8\n" + "Hades 0.8 0.6 0.6 0 5\n"
			+ "Utopia 1.1 1.0 1.0 2 7\n" + "Olympus 0.7 0.4 0.4 1 3\n";

	private final static String SUNDATA = "Sol 1.0 1.0 5778 1.0 4\n" + "Sirius 2.0 1.5 9940 23.6 1\n"
			+ "Proxima 0.12 0.15 3042 0.0017 3\n" + "Alpha 1.5 2.0 10370 80.4 0\n"
			+ "Betelgeuse 20.0 1.0 3130 120000 5\n" + "Vega 2.1 2.7 9602 40.1 2\n" + "Pollux 1.9 8.8 4736 36.0 4\n"
			+ "Arcturus 1.1 25.4 4290 170.0 2\n" + "Deneb 19.0 203.0 8520 196000 1\n"
			+ "Regulus 3.5 3.8 12100 288.0 5\n" + "Antares 15.0 680.0 3590 64000 0\n"
			+ "Rigel 23.0 78.9 12100 120000 3\n" + "Aldebaran 1.1 44.2 3910 400.0 1\n"
			+ "Spica 10.0 7.0 22400 2140.0 0\n" + "Bellatrix 6.0 4.0 22000 800.0 0\n"
			+ "Polaris 5.5 45.0 5800 430.0 0\n" + "Fomalhaut 1.8 1.6 8600 17.9 0\n"
			+ "Achernar 6.2 11.0 15000 850.0 0\n" + "Alnilam 40.0 20.0 27900 375000 0\n"
			+ "Alkaid 2.0 3.0 14000 45.0 1\n" + "Denebola 2.8 2.2 11000 16.0 1\n" + "Mirfak 5.0 5.0 6200 500.0 1\n"
			+ "Wezen 40.0 25.0 18000 140000 1\n" + "Alphard 7.5 2.0 24000 400.0 1\n" + "Alcyone 4.0 4.0 8000 250.0 0\n"
			+ "Mirach 3.0 5.0 9000 220.0 0\n" + "Hamal 2.5 2.0 6700 40.0 0\n" + "Menkar 5.0 7.0 5200 550.0 0\n"
			+ "Mirzam 15.0 10.0 18700 14000 0\n";

	private final static String MOONDATA = "Luna 1.0 1.0 1.0 1\n" + "Phobos 0.8 0.6 0.7 0\n"
			+ "Ganymede 1.2 1.2 1.1 2\n" + "Deimos 0.7 0.4 0.5 0\n" + "Io 1.3 1.5 1.3 2\n" + "Callisto 1.0 0.9 0.9 1\n"
			+ "Enceladus 0.6 0.3 0.4 0\n" + "Triton 1.2 1.1 1.1 0\n" + "Charon 0.8 0.7 0.7 1\n"
			+ "Phoebe 1.0 0.8 0.8 0\n" + "Rhea 0.9 0.6 0.6 1\n" + "Lapetus 1.1 1.0 1.0 2\n" + "Miranda 0.7 0.5 0.5 2\n"
			+ "Titania 1.3 1.2 1.1 2\n" + "Umbriel 0.8 0.6 0.6 0\n" + "Dione 1.1 1.0 1.0 2\n" + "Ariel 0.7 0.4 0.4 1\n"
			+ "Proteus 1.2 1.0 1.0 1\n" + "Nereid 0.8 0.5 0.5 1\n" + "Oberon 1.1 0.9 0.9 2\n" + "Charon 1.2 1.1 1.0 2\n"
			+ "Puck 0.8 0.6 0.6 0\n" + "Caliban 1.1 1.0 1.0 2\n" + "Sycorax 0.7 0.4 0.4 1\n"
			+ "Hyperion 1.0 1.0 1.0 1\n" + "Amalthea 0.8 0.6 0.7 0\n" + "Mimas 1.2 1.2 1.1 2\n"
			+ "Tethys 0.9 0.5 0.6 1\n" + "Thebe 1.1 1.3 1.2 1\n" + "Rhea 0.7 0.4 0.5 0\n" + "Miranda 1.3 1.5 1.3 2\n"
			+ "Callirrhoe 1.0 0.9 0.9 1\n" + "Paaliaq 0.6 0.3 0.4 0\n" + "Ymir 1.2 1.1 1.1 0\n"
			+ "Carme 0.8 0.7 0.7 1\n" + "Ananke 1.0 0.8 0.8 0\n" + "Kalyke 0.9 0.6 0.6 1\n" + "Orthosie 1.1 1.0 1.0 2\n"
			+ "Herse 0.7 0.5 0.5 2\n" + "Aitne 1.3 1.2 1.1 2\n" + "Eurydome 0.8 0.6 0.6 0\n" + "Autonoe 1.1 1.0 1.0 2\n"
			+ "Thyone 0.7 0.4 0.4 1\n" + "Hermippe 1.2 1.1 1.0 1\n" + "Aedea 0.8 0.5 0.5 1\n"
			+ "Euanthe 1.1 0.9 0.9 2\n" + "Helike 0.7 0.4 0.4 1\n" + "Orthosie 1.2 1.0 1.0 1\n"
			+ "Hegemone 0.8 0.6 0.6 1\n" + "Philophrosyne 1.1 1.0 1.0 2\n" + "Dia 0.7 0.4 0.4 1\n"
			+ "Sponde 1.2 1.0 1.0 1\n" + "Kale 0.8 0.5 0.5 1\n" + "Pasithee 1.1 0.9 0.9 2\n"
			+ "Megaclite 0.7 0.4 0.4 1\n" + "Selene 1.0 1.0 1.0 0\n" + "Atlas 0.8 0.6 0.7 1\n" + "Eos 1.2 1.2 1.1 2\n"
			+ "Helios 0.7 0.4 0.5 0\n" + "Artemis 1.3 1.5 1.3 1\n" + "Asteria 1.0 0.9 0.9 2\n"
			+ "Cronus 0.6 0.3 0.4 0\n" + "Phoebe 1.2 1.1 1.1 2\n" + "Diana 0.8 0.7 0.7 1\n" + "Apollo 1.0 0.8 0.8 0\n"
			+ "Aurora 0.9 0.6 0.6 1\n" + "Hyperion 1.1 1.0 1.0 2\n" + "Gaia 0.7 0.5 0.5 2\n" + "Athena 1.3 1.2 1.1 0\n"
			+ "Demeter 0.8 0.6 0.6 0\n" + "Hera 1.1 1.0 1.0 2\n" + "Eros 0.8 0.5 0.5 1\n" + "Hermes 1.2 1.0 1.0 1\n"
			+ "Hestia 0.8 0.5 0.5 1\n" + "Icarus 1.1 0.9 0.9 2\n" + "Iris 0.7 0.4 0.4 1\n" + "Janus 1.2 1.0 1.0 1\n"
			+ "Metis 0.8 0.6 0.6 1\n" + "Nemesis 1.1 1.0 1.0 2\n" + "Pan 0.7 0.5 0.5 2\n" + "Perseus 1.3 1.2 1.1 0\n"
			+ "Tethys 1.1 1.0 1.0 2\n" + "Themis 0.7 0.4 0.4 1\n" + "Zeus 1.2 1.1 1.0 1\n"
			+ "Hephaestus 1.1 0.9 0.9 2\n" + "Nyx 0.7 0.4 0.4 1\n" + "Achilles 1.2 1.0 1.0 1\n"
			+ "Ariadne 0.8 0.5 0.5 1\n";
	
	
	public static String getPlanetdata() {
		return PLANETDATA;
	}

	public static String getSundata() {
		return SUNDATA;
	}

	public static String getMoondata() {
		return MOONDATA;
	}

}
