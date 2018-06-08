package virtualpetsamok;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class VirtualPetTest {

	VirtualPet testPet;

	@Before
	public void setUp() {
		testPet = new VirtualPet(null, null);
	}

	/* Health Tests */

	@Test
	public void shouldHaveHealth() {
		// act
		testPet.setStatHealth(10);
		int health = testPet.getStatHealth();

		// assert
		assertEquals(10, health);

	}

	@Test
	public void healthShouldNotDropBelow0() {
		testPet.setStatHealth(0);
		testPet.tick();
		int health = testPet.getStatHealth();
		assertEquals(0, health);
	}

	/* Happiness Tests */

	@Test
	public void happinessShouldNotDropBelow0() {
		testPet.setStatHappiness(0);
		testPet.tick();
		int happiness = testPet.getStatHappiness();
		assertEquals(0, happiness);
	}

	@Test
	public void shouldHaveHappiness() {
		testPet.setStatHappiness(10);
		int happiness = testPet.getStatHappiness();

		assertEquals(10, happiness);
	}

	@Test
	public void tickShouldRemove1Happiness() {
		testPet.setStatHappiness(5);
		testPet.tick();
		int happiness = testPet.getStatHappiness();
		assertEquals(4, happiness);
	}

	@Test
	public void tickShouldRemoveHealthIfHappinessIs0() {
		testPet.setStatHappiness(1);
		testPet.setStatHealth(5);
		testPet.tick();
		int health = testPet.getStatHealth();
		assertEquals(4, health);
	}

}
