package virtualpetsamok;

public class VirtualPet {

	private static final int DEFAULT_STAT_HEALTH = 15;
	private static final int DEFAULT_STAT_HAPPINESS = 15;

	private String name;
	private String description;
	private int statHealth = DEFAULT_STAT_HEALTH;
	private int statHappiness = DEFAULT_STAT_HAPPINESS;
	
	
	
	/* Constructor */
	
	public VirtualPet(String name, String description) {
		this.name = name;
		this.description = description;
		
	}

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
	
	public void addStatHealth(int health) {
		this.statHealth += health;
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
	
	public void addStatHappiness(int happiness) {
		this.statHappiness += happiness;
	}
	
	/* Inputs */
	
	// Sleep
	public void inputSleep() {
		this.addStatHappiness(9);
	}
	
	// Play
	public void inputPlay() {
		
		this.addStatHappiness(9);
	}
	

	/* Tick Methods for ALL Pets */

	public void tick() {

		// Happiness Calcs
		if (this.statHappiness > 0) {
			this.statHappiness -= 1;
		}

		// Subtract Health if Happiness == 0
		if (this.statHappiness <= 0) {
			if (this.statHealth > 0) {
				this.statHealth -= 1;
			}
		}
		
		// Prevent Health from going lower than 0
		
		if (this.statHealth <= 0) {
			this.statHealth = 0;
		}
	}

	public String getName() {
		return this.name;
	}

}
