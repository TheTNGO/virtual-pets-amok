package virtualpetsamok;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class OrganicPetTest {

	OrganicPet testOrganic;

	/* Inherited from VirtualPet */

	@Before
	public void setUp() {
		testOrganic = new OrganicPet(null, null);
	}

	@Test
	public void shouldHaveHealth() {
		// act
		testOrganic.setStatHealth(10);
		int health = testOrganic.getStatHealth();

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

	@Test
	public void tickShouldRemove1Happiness() {
		testOrganic.setStatHappiness(5);
		testOrganic.tick();
		int happiness = testOrganic.getStatHappiness();
		assertEquals(4, happiness);
	}

	@Test
	public void tickShouldRemoveHealthIfHungerIs0() {
		testOrganic.setStatHunger(0);
		testOrganic.setStatHealth(5);
		int healthBefore = testOrganic.getStatHealth();
		testOrganic.tick();
		int healthAfter = testOrganic.getStatHealth();
		assertThat(healthAfter, is(healthBefore - 1));

	}

}
