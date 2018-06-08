package virtualpetsamok;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class VirtualPetShelterTest {

	VirtualPetShelter underTest;
	VirtualPet testPet1;
	VirtualPet testPet2;

	Litterbox testLitter;

	OrganicDog orgDog1;
	OrganicDog orgDog2;
	RoboDog roboDog1;
	OrganicCat orgCat1;
	OrganicCat orgCat2;

	RoboCat roboCat1;

	@Before
	public void setUp() {
		underTest = new VirtualPetShelter();
		testPet1 = new VirtualPet("Test1", "Test pet");
		testPet2 = new VirtualPet("Test2", "Test pet");

		orgDog1 = new OrganicDog(null, null);
		orgDog2 = new OrganicDog(null, null);
		roboDog1 = new RoboDog(null, null);
		orgCat1 = new OrganicCat(null, null);
		orgCat2 = new OrganicCat(null, null);
		roboCat1 = new RoboCat(null, null);

		testLitter = new Litterbox();

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

	@Test
	public void shouldBeAbleToFeedAllOrganicPets() {
		underTest.addPet(orgDog1);
		underTest.addPet(orgCat1);
		underTest.addPet(roboDog1);
		underTest.inputFeedAll();

		assertEquals(15, roboDog1.getStatHappiness());
		assertEquals(20, orgDog1.getStatHappiness());
		assertEquals(20, orgDog1.getStatHunger());

	}

	@Test
	public void shouldBePutAllPetsToBed() {

		underTest.addPet(orgDog1);
		underTest.addPet(orgCat1);
		underTest.addPet(roboDog1);
		underTest.inputSleepAll();

		assertEquals(20, orgDog1.getStatHappiness());
		assertEquals(20, orgDog1.getStatHealth());
		assertEquals(10, orgDog1.getStatHunger());
		assertEquals(10, orgDog1.getStatThirst());

		assertEquals(20, orgCat1.getStatHappiness());
		assertEquals(20, orgCat1.getStatHealth());
		assertEquals(10, orgCat1.getStatHunger());
		assertEquals(10, orgCat1.getStatThirst());

		assertEquals(20, roboDog1.getStatHappiness());
		assertEquals(20, roboDog1.getStatHealth());

	}

	//
	@Test
	public void shelterTickDegradesAllPetsStats() {

		underTest.addPet(orgDog1);
		underTest.addPet(orgCat1);
		underTest.addPet(roboDog1);
		orgDog1.setStatHappiness(5);
		orgCat1.setStatHappiness(5);
		roboDog1.setStatHappiness(5);

		underTest.tick();

	
		
		assertEquals(4, orgDog1.getStatHappiness());
		assertEquals(4, orgCat1.getStatHappiness());

		assertEquals(4, roboDog1.getStatHappiness());


	}

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

	@Test
	public void shouldBeAbleToCleanAllDogCagesAtOnce() {

		orgDog1.setStatCleanliness(5);
		orgDog2.setStatCleanliness(5);

		underTest.addPet(orgDog1);
		underTest.addPet(orgDog2);

		underTest.inputCleanAllDogs();

		assertEquals(15, orgDog1.getStatCleanliness());
		assertEquals(15, orgDog2.getStatCleanliness());

	}

	@Test
	public void shouldBeAbleToCleanLitterbox() {
		testLitter.setStatCleanliness(5);
		testLitter.inputClean(orgCat1);
		assertEquals(15, testLitter.getStatCleanliness());
	}

	@Test
	public void shouldIncreaseAllCatsHappiness() {

		List<VirtualPet> cats = new ArrayList();
		underTest.addPet(orgCat1);
		underTest.addPet(orgCat2);
		underTest.cleanLitterboxes();
		assertEquals(20, orgCat1.getStatHappiness());
		assertEquals(20, orgCat2.getStatHappiness());

	}

	@Test
	public void shouldIncreaseAllCatHealth() {

		List<VirtualPet> cats = new ArrayList();
		underTest.addPet(orgCat1);
		underTest.addPet(orgCat2);
		underTest.cleanLitterboxes();
		assertEquals(20, orgCat1.getStatHealth());
		assertEquals(20, orgCat2.getStatHealth());

	}

}
