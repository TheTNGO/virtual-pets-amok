package virtualpetsamok;

import static org.hamcrest.Matchers.is;
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
	public void inputWalkShouldIncreaseHappiness() {
		int happinessBefore = testRoboDog.getStatHappiness();
		testRoboDog.inputWalk();
		int happinessAfter = testRoboDog.getStatHappiness();
		assertThat(happinessAfter, is(happinessBefore + 5));
	}
}
