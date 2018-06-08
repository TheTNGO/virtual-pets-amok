package virtualpetsamok;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

public class VirtualPetShelterTest {

	VirtualPetShelter underTest;
	VirtualPet testPet1;
	VirtualPet testPet2;

	OrganicDog orgDog1;
	RoboDog roboDog1;
	OrganicCat orgCat1;
	RoboCat roboCat1;

	@Before
	public void setUp() {
		underTest = new VirtualPetShelter();
		testPet1 = new VirtualPet("Test1", "Test pet");
		testPet2 = new VirtualPet("Test2", "Test pet");

		orgDog1 = new OrganicDog(null, null);
		roboDog1 = new RoboDog(null, null);
		orgCat1 = new OrganicCat(null, null);
		roboCat1 = new RoboCat(null, null);

	}

	@Test
	public void shouldBeAbleToAddOnePetToShelter() {
		underTest.addPet(testPet1);
		Collection<VirtualPet> petNames = underTest.getShelterPetVariables();
		assertThat(petNames, containsInAnyOrder(testPet1));

	}

	@Test
	public void shouldBeAbleToAddTwoPetsToShelter() {
		underTest.addPet(testPet1);
		underTest.addPet(testPet2);

		Collection<VirtualPet> petNames = underTest.getShelterPetVariables();
		assertThat(petNames, containsInAnyOrder(testPet1, testPet2));
	}

	@Test
	public void shouldBeAbleToRemovePets() {
		underTest.addPet(testPet1);
		underTest.addPet(testPet2);

		underTest.removePet(testPet2);

		Collection<VirtualPet> containedPets = underTest.getShelterPetVariables();
		assertThat(containedPets, containsInAnyOrder(testPet1));
	}

	@Test
	public void shouldReturnCollectionOfPets() {
		underTest.addPet(testPet1);
		underTest.addPet(testPet2);

		Collection<String> containedPets = underTest.getPetNames();
		assertThat(containedPets, containsInAnyOrder("Test1", "Test2"));
	}

	// @Test
	// public void shouldBeAbleToFeedAllPets() {
	// underTest.addPet(testPet1);
	// underTest.addPet(testPet2);
	// underTest.inputFeedAll();
	//
	//
	// // Intended order of stats: Nutrition, Energy, Mood
	// // Refactor later by possibly making HashMap for VirtualPet Class
	//
	// Collection<Integer> stats1 = new ArrayList<>();
	// Collection<Integer> stats2 = new ArrayList<>();
	//
	// stats1.add(testPet1.getStatNutrition());
	// stats1.add(testPet1.getStatMood());
	// stats1.add(testPet1.getStatEnergy());
	// stats2.add(testPet2.getStatNutrition());
	// stats2.add(testPet2.getStatMood());
	// stats2.add(testPet2.getStatEnergy());
	//
	// //Based on Starting amount 10 on all pets:
	//
	// assertThat(stats1, contains(15, 15, 15));
	// assertThat(stats2, contains(15, 15, 15));
	//
	// }
	//
	// @Test
	// public void shouldBePutAllPetsToBed() {
	// underTest.addPet(testPet1);
	// underTest.addPet(testPet2);
	// underTest.inputSleepAll();
	//
	//
	// // Intended order of stats: Nutrition, Energy, Mood
	// // Refactor later by possibly making HashMap for VirtualPet Class
	//
	// Collection<Integer> stats1 = new ArrayList<>();
	// Collection<Integer> stats2 = new ArrayList<>();
	//
	// stats1.add(testPet1.getStatNutrition());
	// stats1.add(testPet1.getStatMood());
	// stats1.add(testPet1.getStatEnergy());
	// stats2.add(testPet2.getStatNutrition());
	// stats2.add(testPet2.getStatMood());
	// stats2.add(testPet2.getStatEnergy());
	//
	// //Based on Starting amount 10 on all pets:
	//
	// assertThat(stats1, contains(6, 15, 15));
	// assertThat(stats2, contains(6, 15, 15));
	//
	// }
	//
	// @Test
	// public void shouldPlayWithOnlyTestPet1() {
	// underTest.addPet(testPet1);
	// underTest.addPet(testPet2);
	//
	// underTest.inputPlayWithOne(testPet1);
	//
	//
	// // Intended order of stats: Nutrition, Energy, Mood
	// // Refactor later by possibly making HashMap for VirtualPet Class
	//
	// Collection<Integer> stats1 = new ArrayList<>();
	// Collection<Integer> stats2 = new ArrayList<>();
	//
	// stats1.add(testPet1.getStatNutrition());
	// stats1.add(testPet1.getStatMood());
	// stats1.add(testPet1.getStatEnergy());
	// stats2.add(testPet2.getStatNutrition());
	// stats2.add(testPet2.getStatMood());
	// stats2.add(testPet2.getStatEnergy());
	//
	// //Based on Starting amount 10 on all pets:
	//
	// assertThat(stats1, contains(6, 15, 6));
	// assertThat(stats2, contains(10, 10 ,10 ));
	//
	// }
	//
	// @Test
	// public void shouldPlayWithOnlyTestPet2() {
	// underTest.addPet(testPet1);
	// underTest.addPet(testPet2);
	//
	// underTest.inputPlayWithOne(testPet2);
	//
	// // Intended order of stats: Nutrition, Energy, Mood
	// // Refactor later by possibly making HashMap for VirtualPet Class
	//
	// Collection<Integer> stats1 = new ArrayList<>();
	// Collection<Integer> stats2 = new ArrayList<>();
	//
	// stats1.add(testPet1.getStatNutrition());
	// stats1.add(testPet1.getStatMood());
	// stats1.add(testPet1.getStatEnergy());
	// stats2.add(testPet2.getStatNutrition());
	// stats2.add(testPet2.getStatMood());
	// stats2.add(testPet2.getStatEnergy());
	//
	// //Based on Starting amount 10 on all pets:
	//
	// assertThat(stats1, contains(10, 10, 10));
	// assertThat(stats2, contains(6, 15, 6));
	//
	// }
	//
	// @Test
	// public void shelterTickDegradesAllPetsStats() {
	//
	// underTest.addPet(testPet1);
	// underTest.addPet(testPet2);
	//
	// underTest.tick();
	//
	// // Intended order of stats: Nutrition, Energy, Mood
	// // Refactor later by possibly making HashMap for VirtualPet Class
	//
	// Collection<Integer> stats1 = new ArrayList<>();
	// Collection<Integer> stats2 = new ArrayList<>();
	//
	// stats1.add(testPet1.getStatNutrition());
	// stats1.add(testPet1.getStatMood());
	// stats1.add(testPet1.getStatEnergy());
	// stats2.add(testPet2.getStatNutrition());
	// stats2.add(testPet2.getStatMood());
	// stats2.add(testPet2.getStatEnergy());
	//
	// //Based on Starting amount 10 on all pets:
	//
	// assertThat(stats1, contains(9, 7, 9));
	// assertThat(stats2, contains(9, 7, 9));
	//
	//
	// }

	@Test
	public void shouldOnlyFeedOrganics() {

		orgDog1.setStatHunger(5);
		underTest.addPet(orgDog1);
		underTest.addPet(roboDog1);
		underTest.inputFeedAll();
		assertEquals(10, orgDog1.getStatHunger());
	}

	@Test
	public void shouldOnlyOilRobos() {
		roboDog1.setStatOil(5);
		underTest.addPet(orgDog1);
		underTest.addPet(roboDog1);
		underTest.inputOilAll();
		assertEquals(10, roboDog1.getStatOil());
	}

	@Test
	public void shouldOnlyWalkDogs() {
		underTest.addPet(orgDog1);
		underTest.addPet(roboDog1);
		underTest.addPet(roboCat1);
		underTest.addPet(orgCat1);

		underTest.inputWalkAll();
		assertEquals(20, orgDog1.getStatHappiness());
		assertEquals(7, orgDog1.getStatPoopThresh());

		assertEquals(20, roboDog1.getStatHappiness());

		assertEquals(15, orgCat1.getStatHappiness());

		assertEquals(15, roboCat1.getStatHappiness());

	}

}
