package virtualpetsamok;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class RoboDogTest {

	RoboDog testRoboDog;

	@Before
	public void setUp() {
		testRoboDog = new RoboDog();

	}

	@Test
	public void shouldHaveOilLevel() {
		int oil = testRoboDog.getStatOil();
		assertEquals(15, oil);

	}

	@Test
	public void shouldSubtractHealthByOneWhenOilIsAt0OnTick() {
		int healthBefore = testRoboDog.getStatHealth();
		testRoboDog.setStatOil(0);
		testRoboDog.tick();
		int healthAfter = testRoboDog.getStatHealth();
		assertThat(healthAfter, is(healthBefore - 1));
	}

	public void shouldSubtractHappinessByTwoWhenOilIsAt0OnTick() {
		int happinessBefore = testRoboDog.getStatHealth();
		testRoboDog.setStatOil(0);
		testRoboDog.tick();
		int happinessAfter = testRoboDog.getStatHealth();
		assertThat(happinessAfter, is(happinessBefore - 2));
	}

	@Test
	public void inputWalkShouldIncreaseHappiness() {
		int happinessBefore = testRoboDog.getStatHappiness();
		testRoboDog.inputWalk();
		int happinessAfter = testRoboDog.getStatHappiness();
		assertThat(happinessAfter, is(happinessBefore + 5));
	}
}
