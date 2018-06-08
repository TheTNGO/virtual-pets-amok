package virtualpetsamok;

public class OrganicPet extends VirtualPet {

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

	public void setStatThirst(int thirst) {
		this.statThirst = thirst;
	}

	public int getStatThirst() {
		// TODO Auto-generated method stub
		return this.statThirst;
	}

}
