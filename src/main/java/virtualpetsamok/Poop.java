package virtualpetsamok;

public interface Poop {
		
	public default void poop (Litterbox litterbox) {
		litterbox.receivePoop();
	}
	
}
