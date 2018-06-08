package virtualpetsamok;

public class VirtualPet {
	
	private static final int DEFAULT_STAT_HEALTH = 15;
	private static final int DEFAULT_STAT_HAPPINESS = 15;

	private int statHealth = DEFAULT_STAT_HEALTH ;
	private int statHappiness = DEFAULT_STAT_HAPPINESS;

	/* Health Methods */

	public int getStatHealth() {
		return this.statHealth;
	}

	public void subtractStatHealth(int health) {
		this.statHealth -= health;
	}

	public void setStatHealth(int health) {
		this.statHealth = health;

	}

	/* Happiness Methods */

	public void setStatHappiness(int happiness) {
		this.statHappiness = happiness;
	}

	public int getStatHappiness() {
		return this.statHappiness;
	}

	public void subtractStatHappiness(int happiness) {
		this.statHappiness -= happiness;
	}

	/* Tick Methods for ALL Pets */

	public void tick() {

		// Happiness Calcs
		if (this.statHappiness > 0) {
			this.statHappiness -= 1;
		}
		
		// Subtract Health if Happiness == 0
		if (this.statHappiness == 0) {
			if (this.statHealth > 0) {
				this.statHealth -= 1;
			}
		}
	}

}
