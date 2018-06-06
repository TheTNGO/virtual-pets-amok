package virtualpetsamok;

public class OrganicDog extends OrganicPet implements Poop{
	
	private int statPoopThresh;
	private int statClealiness;

	public void inputWalk() {
		this.setStatHappiness(this.getStatHappiness() + 1);
		this.setStatPoopThresh(this.getStatPoopThresh() + 1);
		
	}
	
	//Poop Threshold
	// Dog will poop at 0 on tick	
	public void setStatPoopThresh(int amount) {
		this.statPoopThresh = amount;
	}

	public int getStatPoopThresh() {
		return this.statPoopThresh;
	}

	
	// Cage Cleanliness
	public void setStatCleanliness(int amount) {
		this.statClealiness = amount;
		
	}

	public int getStatCleanliness() {
		return this.statClealiness;
	}
	
	public void poop() {
		this.statClealiness -= 1;
	}
	
	
	
	

}
