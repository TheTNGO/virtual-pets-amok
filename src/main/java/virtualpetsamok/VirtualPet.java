package virtualpetsamok;

public class VirtualPet {

	private int statHealth;
	private int statHappiness;

	
	/* Health Methods */
	
	public int getHealth() {
		return this.statHealth;
	}
	
	public void subtractStatHealth(int health) {
		this.statHealth -= health;
	}

	public void setHealth(int health) {
		this.statHealth = health;
			
	}

	/* Happiness Methods */
	
	public void setHappiness(int happiness) {
		this.statHappiness = happiness;
	}

	public int getHappiness() {
		return this.statHappiness;
	}
	
	public void subtractStatHappiness(int happiness){
		this.statHappiness -= happiness;
	}
			
	
	
	
}