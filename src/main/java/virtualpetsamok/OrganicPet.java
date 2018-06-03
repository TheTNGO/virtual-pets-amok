package virtualpetsamok;

public class OrganicPet extends VirtualPet {

	private int statHunger;
	private int statThirst;

	public void setHunger(int hunger) {
		this.statHunger = hunger;
	}
	
	public int getHunger() {
		return this.statHunger;
	}

	public void setThirst(int thirst) {
		this.statThirst = thirst;
	}

	public int getThirst() {
		// TODO Auto-generated method stub
		return this.statThirst;
	}

}
