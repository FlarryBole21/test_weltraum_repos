package space.inventory.item.weapon;

public class QuantumTorpedo extends Missile{

	public QuantumTorpedo(int strength) {
		super(strength);
		super.setType("Quantumtorpedo");
	}

	@Override
	public String getType() {
		return "Quantum-Torpedo";
	}

}
