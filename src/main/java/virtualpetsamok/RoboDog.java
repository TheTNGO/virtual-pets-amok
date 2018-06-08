package virtualpetsamok;

public class RoboDog extends RoboPet {

	public void inputWalk() {
		this.setStatHappiness(this.getStatHappiness() + 5);
	}

	public void tick() {
		super.tick();
	}

}
