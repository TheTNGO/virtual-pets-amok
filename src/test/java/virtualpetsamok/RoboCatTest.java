package virtualpetsamok;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class RoboCatTest {
	
	RoboCat testRoboCat;
	
	@Before
	public void setUp() {
		testRoboCat = new RoboCat();
	}
	
	@Test
	public void shouldHaveOilLevel() {
		int oil = testRoboCat.getStatOil();
		assertEquals(15, oil);

	}

	@Test
	public void shouldSubtractHealthByOneWhenOilIsAt0OnTick() {
		int healthBefore = testRoboCat.getStatHealth();
		testRoboCat.setStatOil(0);
		testRoboCat.tick();
		int healthAfter = testRoboCat.getStatHealth();
		assertThat(healthAfter, is(healthBefore - 1));
	}

	public void shouldSubtractHappinessByTwoWhenOilIsAt0OnTick() {
		int happinessBefore = testRoboCat.getStatHealth();
		testRoboCat.setStatOil(0);
		testRoboCat.tick();
		int happinessAfter = testRoboCat.getStatHealth();
		assertThat(happinessAfter, is(happinessBefore - 2));
	}
}
