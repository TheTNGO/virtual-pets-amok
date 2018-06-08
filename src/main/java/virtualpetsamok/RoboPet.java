package virtualpetsamok;

public class RoboPet extends VirtualPet {

	public RoboPet(String name, String description) {
		super(name, description);
	}

	private static final int DEFAULT_STAT_OIL = 15;

	private int statOil = DEFAULT_STAT_OIL;

	public int getStatOil() {
		return this.statOil;
	}

	public void setStatOil(int amount) {
		this.statOil = amount;

	}
	
	public void inputOil() {
		this.statOil += 5;
	}

	@Override
	public void tick() {
		super.tick();
		
		if(this.statOil > 0) {
			this.statOil -= 1;

		}

		if (this.statOil <= 0) {
			this.subtractStatHealth(1);
			this.subtractStatHappiness(1);

		}
	}
	

}
