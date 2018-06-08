package virtualpetsamok;

public class Litterbox {

	private static final int DEFAULT_STAT_CLEANLINESS = 15;
	private int statCleanliness = DEFAULT_STAT_CLEANLINESS;

	public int getStatCleanliness() {
		return this.statCleanliness;
	}

	public void receivePoop() {
		this.statCleanliness -= 1;

	}

	public void dirtyDamage(OrganicCat cat) {
		if (this.statCleanliness <= 0) {
			cat.subtractStatHealth(1);
			cat.subtractStatHappiness(1);
		}
	}

	public void setStatCleanliness(int cleanliness) {
		this.statCleanliness = cleanliness;

	}

}
