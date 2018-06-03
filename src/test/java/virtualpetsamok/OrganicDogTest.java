package virtualpetsamok;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class OrganicDogTest {
	
	OrganicDog testOrgDog1;
	OrganicDog testOrgDog2;
	Litterbox testLitter = new Litterbox();
	

	@Before
	public void setUp() {
		testOrgDog1 = new OrganicDog();
		testOrgDog2 = new OrganicDog();
		
	}

	@Test
	public void shouldHaveHealth() {
		// act
		testOrgDog1.setHealth(10);
		int health = testOrgDog1.getHealth();

		// assert
		assertEquals(10, health);
	}
	
	@Test
	public void shouldHaveHunger() {
		testOrgDog1.setHunger(10);
		int hunger = testOrgDog1.getHunger();
		
		assertEquals(10, hunger);
	}
	
	@Test
	public void shouldHaveThirst() {
		
		testOrgDog1.setThirst(10);
		int hunger = testOrgDog1.getThirst();
		
		assertEquals(10, hunger);
		
	}
	
	@Test
	public void shouldHaveHappiness() {
		testOrgDog1.setHappiness(10);
		int happiness = testOrgDog1.getHappiness();
		
		assertEquals(10, happiness);
	}
	

	@Test
	public void walkiesMakeDogHappy() {
		testOrgDog1.setHappiness(4);
		testOrgDog1.beWalked();
		int happiness = testOrgDog1.getHappiness();
		assertEquals(happiness, 5);
		
	}

}
