package virtualpetsamok;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class OrganicCatTest {

	OrganicCat testOrganicCat1;
	OrganicCat testOrganicCat2;
	Litterbox testLitter;

	@Before
	public void setUp() {
		testOrganicCat1 = new OrganicCat();
		testOrganicCat2 = new OrganicCat();
		testLitter = new Litterbox();
	}

	/* Inheritance (VirtualPet) Tests */

	@Test
	public void shouldHaveHealth() {
		// act
		testOrganicCat1.setStatHealth(10);
		int health = testOrganicCat1.getStatHealth();

		// assert
		assertEquals(10, health);

	}

	@Test
	public void shouldHaveHappiness() {
		testOrganicCat1.setStatHappiness(10);
		int happiness = testOrganicCat1.getStatHappiness();

		assertEquals(10, happiness);
	}

	/* Inheritance (OrganicPet) Tests */

	@Test
	public void shouldHaveHunger() {
		testOrganicCat1.setStatHunger(10);
		int hunger = testOrganicCat1.getStatHunger();

		assertEquals(10, hunger);
	}

	@Test
	public void shouldHaveThirst() {

		testOrganicCat1.setStatThirst(10);
		int hunger = testOrganicCat1.getStatThirst();

		assertEquals(10, hunger);

	}

	/* Organic Cat Exclusive */

	@Test
	public void shouldPoopInLitterBox() {
		int litterCleanlinessBefore = testLitter.getStatCleanliness();
		testOrganicCat1.poop(testLitter);
		int litterCleanlinessAfter = testLitter.getStatCleanliness();

		assertEquals((litterCleanlinessBefore - 1), litterCleanlinessAfter);

	}

	@Test
	public void shouldLoseHealthIfLitterBoxCleanlinessIs0() {
		testLitter.setStatCleanliness(0);
		testOrganicCat1.setStatHealth(15);
		testLitter.dirtyDamage(testOrganicCat1);
		int health = testOrganicCat1.getStatHealth();
		assertEquals(health, 14);

	}

	@Test
	public void tickShouldRemove1Happiness() {
		testOrganicCat1.setStatHappiness(5);
		testOrganicCat1.tick();
		int happiness = testOrganicCat1.getStatHappiness();
		assertEquals(4, happiness);
	}

	@Test
	public void shouldPoopOnTick() {
		testLitter.setStatCleanliness(5);
		testOrganicCat1.tick(testLitter);
		int litter = testLitter.getStatCleanliness();
		assertEquals(4, litter);
	}

	@Test
	public void shouldLoseHappinessIfLitterboxIsNotClean() {
		testOrganicCat1.setStatHappiness(3);
		testLitter.setStatCleanliness(0);
		int happinessBefore = testOrganicCat1.getStatHappiness();
		testOrganicCat1.tick(testLitter);
		int happinessAfter = testOrganicCat1.getStatHappiness();
		assertThat(happinessAfter, is(happinessBefore - 2));
	}

}
