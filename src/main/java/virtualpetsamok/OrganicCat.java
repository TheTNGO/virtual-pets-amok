package virtualpetsamok;

public class OrganicCat extends OrganicPet implements Poop{
	
	@Override
	public void poop(Litterbox litterbox) {
		litterbox.receivePoop();
	}

}
