package virtualpetsamok;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class OrganicCatTest {
	
	OrganicCat testOrganicCat;
	Litterbox testLitter;

	@Before
	public void setUp() {
		testOrganicCat = new OrganicCat();
		testLitter = new Litterbox();
	}
	
	@Test
	public void shouldHaveHealth() {
		// act
		testOrganicCat.setHealth(10);
		int health = testOrganicCat.getHealth();

		// assert
		assertEquals(10, health);

	}
	
	@Test
	public void shouldHaveHappiness() {
		testOrganicCat.setHappiness(10);
		int happiness = testOrganicCat.getHappiness();
		
		assertEquals(10, happiness);
	}
	
	@Test
	public void shouldHaveHunger() {
		testOrganicCat.setHunger(10);
		int hunger = testOrganicCat.getHunger();
		
		assertEquals(10, hunger);
	}
	
	@Test
	public void shouldHaveThirst() {
		
		testOrganicCat.setThirst(10);
		int hunger = testOrganicCat.getThirst();
		
		assertEquals(10, hunger);
		
	}
	
	@Test
	public void shouldPoopInLitterBox() {
		int LitterCleanlinessBefore = testLitter.getLitterboxCleanliness();
		testOrganicCat.poop(testLitter);
		int LitterCleanlinessAfter = testLitter.getLitterboxCleanliness();
		
		assertEquals(LitterCleanlinessBefore -1, LitterCleanlinessAfter);
		
	}
	
	

}
