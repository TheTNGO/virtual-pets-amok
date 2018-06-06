package virtualpetsamok;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class OrganicPetTest {
	
	OrganicPet testOrganic;
	
	/* Inherited from VirtualPet */
	
	@Before
	public void setUp() {
		testOrganic = new OrganicPet();
	}
	
	@Test
	public void shouldHaveHealth() {
		// act
		testOrganic.setHealth(10);
		int health = testOrganic.getHealth();

		// assert
		assertEquals(10, health);

	}
	
	@Test
	public void shouldHaveHappiness() {
		testOrganic.setStatHappiness(10);
		int happiness = testOrganic.getStatHappiness();
		
		assertEquals(10, happiness);
	}
	
	/* Organic Exclusive */ 
	
	@Test
	public void shouldHaveHunger() {
		testOrganic.setStatHunger(10);
		int hunger = testOrganic.getStatHunger();
		
		assertEquals(10, hunger);
	}
	
	@Test
	public void shouldHaveThirst() {
		
		testOrganic.setStatThirst(10);
		int hunger = testOrganic.getStatThirst();
		
		assertEquals(10, hunger);
		
	}
	

	
	
}
