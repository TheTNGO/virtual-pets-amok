package virtualpetsamok;

public class OrganicCat extends OrganicPet implements Poop{
	
	
	
	public void tick(Litterbox litterbox){
		super.tick();
		this.poop(litterbox);
		litterbox.dirtyDamage(this);
	}
	
	@Override
	public void poop(Litterbox litterbox) {
		litterbox.receivePoop();
	}
	
	

}
