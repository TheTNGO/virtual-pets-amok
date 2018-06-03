package virtualpetsamok;

public class Litterbox {
	
	private static final int DEFAULT_STAT_CLEANLINESS = 15;
	private int statCleanliness = DEFAULT_STAT_CLEANLINESS;

	public int getLitterboxCleanliness() {
		return this.statCleanliness;
	}

	public void receivePoop() {
		this.statCleanliness -= 1;
		
	}

}
