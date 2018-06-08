package virtualpetsamok;

public class RoboCat extends RoboPet {

	public RoboCat(String name, String description) {
		super(name, description);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	public String toString() {
		String readout = "Name: " + this.getName() + "\t\tClass: " + this.getClass().getSimpleName() + "\t\tHealth: " + this.getStatHealth() + "\tHappiness: " + this.getStatHappiness()
		+ "\tOil: " + this.getStatOil();
		return readout;
	}

}
