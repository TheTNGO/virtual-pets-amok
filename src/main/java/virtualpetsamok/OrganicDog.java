package virtualpetsamok;

public class OrganicDog extends OrganicPet implements Poop{
	
	private int statPoopThresh;
	private int statClealiness;

	public void inputWalk() {
		this.setStatHappiness(this.getStatHappiness() + 5);
		this.setStatPoopThresh(this.getStatPoopThresh() + 2);
		
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
	
	@Override
	public void tick() {
		super.tick();
		
		if(this.getStatCleanliness() <= 0) {
			this.subtractStatHealth(1);
			this.subtractStatHappiness(1);
		}
		
		this.statPoopThresh -= 1;
		if(this.getStatPoopThresh() <=0) {
			this.poop();
			this.setStatPoopThresh(3);
		}
	}
	
	
	
	

}
