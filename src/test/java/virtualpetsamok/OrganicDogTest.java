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
		testOrgDog1.setStatHunger(10);
		int hunger = testOrgDog1.getStatHunger();
		
		assertEquals(10, hunger);
	}
	
	@Test
	public void shouldHaveThirst() {
		
		testOrgDog1.setStatThirst(10);
		int hunger = testOrgDog1.getStatThirst();
		
		assertEquals(10, hunger);
		
	}
	
	
	@Test
	public void shouldHaveHappiness() {
		testOrgDog1.setStatHappiness(10);
		int happiness = testOrgDog1.getStatHappiness();
		
		assertEquals(10, happiness);
	}
	

	@Test
	public void walkingDogIncreasesStatHappiness() {
		testOrgDog1.setStatHappiness(4);
		testOrgDog1.inputWalk();
		int happiness = testOrgDog1.getStatHappiness();
		assertEquals(happiness, 5);
		
	}
	
	@Test
	public void walkingDogIncreasesPoopThreshold() {
		testOrgDog1.setStatPoopThresh(1);
		testOrgDog1.inputWalk();
		int poopThresh = testOrgDog1.getStatPoopThresh();
		assertEquals(2, poopThresh);
	}
	
	@Test
	public void poopingShouldAffectDogsOwnCleanliness() {
		testOrgDog1.setStatCleanliness(5);
		testOrgDog1.poop();
		int cleanliness = testOrgDog1.getStatCleanliness();
		assertEquals(4, cleanliness);
	}
	
	
	
	

}
