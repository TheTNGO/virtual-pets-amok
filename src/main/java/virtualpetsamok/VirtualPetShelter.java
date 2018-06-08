package virtualpetsamok;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class VirtualPetShelter {

	List<VirtualPet> shelter = new ArrayList<>();
	Litterbox litterbox = new Litterbox();

	public void addPet(VirtualPet pet) {

		shelter.add(pet);

	}

	public void removePet(VirtualPet petToBeRemoved) {
		List<VirtualPet> toRemove = new ArrayList<>();
		for (VirtualPet elements : shelter) {
			if (petToBeRemoved == elements) {
				toRemove.add(elements);
			}
		}

		shelter.removeAll(toRemove);
	}

	public Collection<String> getPetNames() {
		List<String> petNames = new ArrayList<>();
		for (VirtualPet elements : shelter) {
			petNames.add(elements.getName());
		}
		return petNames;

	}

	public void inputFeedAll() {
		for (VirtualPet elems : shelter) {
			if (elems instanceof OrganicPet) {
				((OrganicPet) elems).inputFeed();
			}
		}
	}

	public void inputOilAll() {
		for (VirtualPet elems : shelter) {
			if (elems instanceof RoboPet) {
				((RoboPet) elems).inputOil();
			}
		}
	}

	public void inputSleepAll() {

		for (VirtualPet elems : shelter) {
			elems.inputSleep();

		}
	}

	public void inputPlayWithOne(VirtualPet petToPlay) {

		for (VirtualPet elems : shelter) {
			if (petToPlay == elems) {
				elems.inputPlay();
			}
		}
	}

	public void tick() {
		for (VirtualPet elems : shelter) {
			if (elems instanceof OrganicCat) {
				((OrganicCat) elems).tick(litterbox);
			} else {
				elems.tick();
			}
		}
	}

	public Collection<VirtualPet> getShelterPetVariables() {
		return shelter;
	}

	public void inputWalkAll() {
		for (VirtualPet elems : shelter) {
			if (elems instanceof RoboDog || elems instanceof OrganicDog) {
				if (elems instanceof RoboDog) {
					((RoboDog) elems).inputWalk();
				} else {
					((OrganicDog) elems).inputWalk();
				}
			}
		}
	}

	public void inputCleanAllDogs() {
		for (VirtualPet elems : shelter) {
			if (elems instanceof OrganicDog) {
				((OrganicDog) elems).inputClean();
			}
		}
	}

	public void cleanLitterboxes() {
		for (VirtualPet elems : shelter) {
			if (elems instanceof OrganicCat) {
				litterbox.inputClean((OrganicCat) elems);
			}
		}
	}
}
