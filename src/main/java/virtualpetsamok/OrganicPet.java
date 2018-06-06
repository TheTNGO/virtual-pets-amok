package virtualpetsamok;

public class OrganicPet extends VirtualPet {

	private int statHunger;
	private int statThirst;

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
