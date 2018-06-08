package virtualpetsamok;

public class RoboDog extends RoboPet {

	public RoboDog(String name, String description) {
		super(name, description);
	}

	public void inputWalk() {
		this.setStatHappiness(this.getStatHappiness() + 5);
		this.addStatHealth(5);
	}
	
	@Override
	public void tick() {
		super.tick();
	}

}
