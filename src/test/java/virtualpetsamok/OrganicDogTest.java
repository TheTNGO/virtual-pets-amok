package virtualpetsamok;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

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
		testOrgDog1.setStatHealth(10);
		int health = testOrgDog1.getStatHealth();

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
	public void tickShouldRemove1Happiness() {
		testOrgDog1.setStatCleanliness(5);
		testOrgDog1.setStatHappiness(5);
		testOrgDog1.tick();
		int happiness = testOrgDog1.getStatHappiness();
		assertEquals(4, happiness);
	}

	@Test
	public void tickShouldRemoveHealthIfHappinessIs0() {
		testOrgDog1.setStatCleanliness(5);
		testOrgDog1.setStatHappiness(1);
		testOrgDog1.setStatHealth(5);
		testOrgDog1.tick();
		int health = testOrgDog1.getStatHealth();
		assertEquals(4, health);
		
		
	}
	

	@Test
	public void walkingDogIncreasesStatHappiness() {
		testOrgDog1.setStatHappiness(4);
		testOrgDog1.inputWalk();
		int happiness = testOrgDog1.getStatHappiness();
		assertEquals(happiness, 9);
		
	}
	
	@Test
	public void walkingDogIncreasesPoopThreshold() {
		testOrgDog1.setStatPoopThresh(1);
		testOrgDog1.inputWalk();
		int poopThresh = testOrgDog1.getStatPoopThresh();
		assertEquals(3, poopThresh);
	}
	
	@Test
	public void poopingShouldAffectDogsOwnCleanliness() {
		testOrgDog1.setStatCleanliness(5);
		testOrgDog1.poop();
		int cleanliness = testOrgDog1.getStatCleanliness();
		assertEquals(4, cleanliness);
	}
	
		
	@Test
	public void shouldLoseHealthIfCageIsNotClean() {
		testOrgDog1.setStatCleanliness(0);
		testOrgDog1.tick();
		int health = testOrgDog1.getStatHealth();
		assertEquals(14, health);
	}
	
	@Test
	public void shouldPoopIfPoopThreshIs0OnTick() {
		testOrgDog1.setStatPoopThresh(1);
		testOrgDog1.setStatCleanliness(1);
		int cleanlinessBefore = testOrgDog1.getStatCleanliness();
		testOrgDog1.tick();
		int cleanlinessAfter = testOrgDog1.getStatCleanliness();
		assertThat(cleanlinessAfter, is(cleanlinessBefore - 1));
	}
	
	@Test
	public void poopingShouldResetPoopThreshTo3() {
		testOrgDog1.setStatPoopThresh(1);
		testOrgDog1.tick();
		int poopThreshAfter = testOrgDog1.getStatPoopThresh();
		assertThat(poopThreshAfter, is(5));
	}
	
	@Test
	public void shouldLoseHappinessIfCageIsNotClean() {
		testOrgDog1.setStatCleanliness(0);
		testOrgDog1.tick();
		int happiness = testOrgDog1.getStatHappiness();
		assertEquals(13, happiness);
	}
	

	
	
	

}
