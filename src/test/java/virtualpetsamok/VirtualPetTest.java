package virtualpetsamok;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class VirtualPetTest {

	VirtualPet testPet;

	@Before
	public void setUp() {
		testPet = new VirtualPet();
	}

	@Test
	public void shouldHaveHealth() {
		// act
		testPet.setHealth(10);
		int health = testPet.getHealth();

		// assert
		assertEquals(10, health);

	}
	
	@Test
	public void shouldHaveHappiness() {
		testPet.setStatHappiness(10);
		int happiness = testPet.getStatHappiness();
		
		assertEquals(10, happiness);
	}
	

}
