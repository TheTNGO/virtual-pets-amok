package virtualpetsamok;

public class OrganicPet extends VirtualPet implements Poop {

	public OrganicPet(String name, String description) {
		super(name, description);
	}

	private int statHunger = DEFAULT_STAT_HUNGER;
	private int statThirst = DEFAULT_STAT_THIRST;

	private static final int DEFAULT_STAT_HUNGER = 15;
	private static final int DEFAULT_STAT_THIRST = 15;

	public void setStatHunger(int hunger) {
		this.statHunger = hunger;
	}

	public int getStatHunger() {
		return this.statHunger;
	}

	private void addStatHunger(int amount) {
		this.statHunger += amount;
	}

	private void subtractStatHunger(int amount) {
		this.statHunger -= amount;
	}

	public void setStatThirst(int thirst) {
		this.statThirst = thirst;
	}

	public int getStatThirst() {
		// TODO Auto-generated method stub
		return this.statThirst;
	}

	private void addStatThirst(int amount) {
		this.statThirst += amount;
	}

	private void subtractStatThirst(int amount) {
		this.statThirst -= amount;
	}

	/* Inputs */

	public void inputFeed() {
		this.addStatHunger(5);
		this.addStatHappiness(5);
	}

	public void inputWater() {
		this.addStatThirst(5);
		this.addStatHappiness(5);
	}

	public void inputPlay() {
		this.subtractStatHunger(5);
		this.subtractStatThirst(5);
	}

	public void inputSleep() {
		super.inputSleep();
		this.subtractStatHunger(5);
		this.subtractStatThirst(5);

	}
	
	@Override
	public void tick() {
		super.tick();
		this.statHunger -= 1;
		this.statThirst -= 1;
	}
	
	
	@Override
	public void poop() {
		System.out.println("\n" + this.getName() + " pooped.");
	}
}
