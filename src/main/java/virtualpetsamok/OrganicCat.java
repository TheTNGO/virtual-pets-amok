package virtualpetsamok;

public class OrganicCat extends OrganicPet implements Poop {

	public OrganicCat(String name, String description) {
		super(name, description);
	}

	public void tick(Litterbox litterbox) {
		super.tick();
		this.poop(litterbox);
		litterbox.dirtyDamage(this);
	}

	@Override
	public void poop(Litterbox litterbox) {
		litterbox.receivePoop();
	}

	@Override
	public String toString() {
		String readout = "Name: " + this.getName() + "\t\tClass: " + this.getClass().getSimpleName() + "\t\tHealth: " + this.getStatHealth() + "\tHappiness: " + this.getStatHappiness()
		+ "\tHunger/Thirst: " + this.getStatHunger() + "/" + this.getStatThirst();
		return readout;
	}

}
