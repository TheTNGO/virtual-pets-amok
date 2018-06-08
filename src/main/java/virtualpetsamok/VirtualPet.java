package virtualpetsamok;

public class VirtualPet {

	private int statHealth;
	private int statHappiness;

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

		if (this.statHappiness == 0) {
			if (this.statHealth > 0) {
				this.statHealth -= 1;
			}
		}
	}

}
