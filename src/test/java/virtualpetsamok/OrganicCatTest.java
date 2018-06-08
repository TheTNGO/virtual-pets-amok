package virtualpetsamok;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

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
		int litterCleanlinessBefore = testLitter.getLitterboxCleanliness();
		testOrganicCat1.poop(testLitter);
		int litterCleanlinessAfter = testLitter.getLitterboxCleanliness();

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
		int litter = testLitter.getLitterboxCleanliness();
		assertEquals(4, litter);
	}

}
