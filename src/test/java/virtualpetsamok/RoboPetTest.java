package virtualpetsamok;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class RoboPetTest {

	RoboPet testRobo;

	@Before
	public void setUp() {
		testRobo = new RoboPet(null, null);
	}

	@Test
	public void shouldHaveOilLevel() {
		int oil = testRobo.getStatOil();
		assertEquals(15, oil);

	}

	@Test
	public void shouldSubtractHealthByOneWhenOilIsAt0OnTick() {
		int healthBefore = testRobo.getStatHealth();
		testRobo.setStatOil(0);
		testRobo.tick();
		int healthAfter = testRobo.getStatHealth();
		assertThat(healthAfter, is(healthBefore - 1));
	}

	public void shouldSubtractHappinessByTwoWhenOilIsAt0OnTick() {
		int happinessBefore = testRobo.getStatHealth();
		testRobo.setStatOil(0);
		testRobo.tick();
		int happinessAfter = testRobo.getStatHealth();
		assertThat(happinessAfter, is(happinessBefore - 2));
	}

}
