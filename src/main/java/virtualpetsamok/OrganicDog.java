package virtualpetsamok;

public class OrganicDog extends OrganicPet implements Poop {

	public OrganicDog(String name, String description) {
		super(name, description);
	}

	private static final int DEFAULT_STAT_POOPTHRESH = 5;
	private static final int DEFAULT_STAT_CLEANLINESS = 15;

	private int statPoopThresh = DEFAULT_STAT_POOPTHRESH;
	private int statCleanliness = DEFAULT_STAT_CLEANLINESS;

	public void inputWalk() {
		this.setStatHappiness(this.getStatHappiness() + 5);
		this.setStatPoopThresh(this.getStatPoopThresh() + 2);
		this.addStatHealth(5);
		;
	}

	// Poop Threshold
	// Dog will poop at 0 on tick
	public void setStatPoopThresh(int amount) {
		this.statPoopThresh = amount;
	}

	public int getStatPoopThresh() {
		return this.statPoopThresh;
	}

	// Cage Cleanliness
	public void setStatCleanliness(int amount) {
		this.statCleanliness = amount;

	}

	public int getStatCleanliness() {
		return this.statCleanliness;
	}

	public void poop() {
		super.poop();
		this.statCleanliness -= 1;
	}

	@Override
	public void tick() {
		super.tick();

		if (this.getStatCleanliness() <= 0) {
			this.subtractStatHealth(1);
			this.subtractStatHappiness(1);
		}

		this.statPoopThresh -= 1;
		if (this.getStatPoopThresh() <= 0) {
			this.poop();
			this.setStatPoopThresh(DEFAULT_STAT_POOPTHRESH);
		}
	}

	public void inputClean() {
		this.statCleanliness = DEFAULT_STAT_CLEANLINESS;
	}

	@Override
	public String toString() {
		String readout = "Name: " + this.getName( )+ "\t\tClass: " + this.getClass().getSimpleName() + "\t\tHealth: " + this.getStatHealth() + "\tHappiness: " + this.getStatHappiness()
		+ "\tHunger/Thirst: " + this.getStatHunger() + "/" + this.getStatThirst() + "\tCage Cleanliness: " + this.statCleanliness + "\tPoop Threshhold: "
		+ this.getStatPoopThresh();
		return readout;
	}

}
