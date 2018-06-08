package virtualpetsamok;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class VirtualPetsAmokApp {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		VirtualPetShelter currentShelter = new VirtualPetShelter();

		/* Pet Slots */

		VirtualPet pet1 = new OrganicDog("Roxanne", "Healthy, jolly, and ready to [Do Thing(s)]");
		VirtualPet pet2 = new OrganicCat("Maxamillion", "Seems easily spooked, but loves a good meal!");
		VirtualPet pet3 = new RoboDog("R3X", "*Buzz* *exec bark.cfg*");
		VirtualPet pet4 = new RoboCat("WH1SK3RS", "Cannot find 'meow.wav'");
		VirtualPet pet5;

		/* Default entries into shelter */

		currentShelter.addPet(pet1);
		currentShelter.addPet(pet2);
		currentShelter.addPet(pet3);
		currentShelter.addPet(pet4);

		currentShelter.toString();

		/* Intro */

		System.out.println("Welcome to your Virtual Pet Shelter!");

		while (true) {

			/* Stats Readout */

			System.out.println("Here are the pets you'll be taking care of today:\n");

			Collection<VirtualPet> pets = currentShelter.getShelterPetVariables();

			for (VirtualPet currentPet : pets) {
				System.out.println(currentPet.toString());
			}

			System.out.println("\nLitterbox Cleanliness: " + currentShelter.getLitterboxCleanliness());

			System.out.println("\nYou have room for " + (5 - pets.size()) + " more pets");

			System.out.println("\nWhat would you like to do?\n");
			System.out.println("1. Feed all organic pets");
			System.out.println("2. Water all organic pets");
			System.out.println("3. Oil all organic pets");

			System.out.println("4. Walk All Dogs");

			System.out.println("5. Play with a pet");
			System.out.println("6. Put all pets to bed");
			System.out.println("7. Do nothing");
			System.out.println();
			System.out.println("8. Take a new pet into the shelter");
			System.out.println("9. Remove a pet from the shelter");
			System.out.println();
			System.out.println("10. Quit");
			String choice = input.nextLine();

			/* Input Results */

			// Invalid Option

			while (!(choice.equalsIgnoreCase("1")) && !(choice.equalsIgnoreCase("2")) && !(choice.equalsIgnoreCase("3"))
					&& !(choice.equalsIgnoreCase("4")) && !(choice.equalsIgnoreCase("5"))
					&& !(choice.equalsIgnoreCase("6")) && !(choice.equalsIgnoreCase("7"))
					&& !(choice.equalsIgnoreCase("8")) && !(choice.equalsIgnoreCase("9"))
					&& !(choice.equalsIgnoreCase("10"))) {
				System.out.println("\nThe pets seem to be confused.");
				System.out.println("Please enter a valid option.");
				choice = input.nextLine();
			}

			// Feed
			if (choice.equalsIgnoreCase("1")) {
				currentShelter.inputFeedAll();
				currentShelter.tick();

				System.out.println("\nThe organic pets happily munch on virtual food. Loudly. ");
				System.out.println("They're all virtually happy to eat!\n");

				// Water
			} else if (choice.equalsIgnoreCase("2")) {
				currentShelter.inputWaterAll();
				currentShelter.tick();

				System.out.println("The organics happily lap up the water in their bowls.");

				// Oil
			} else if (choice.equalsIgnoreCase("3")) {
				currentShelter.inputOilAll();
				currentShelter.tick();

				System.out.println("The robotic animals seem happy to be given routine maintenance.");

				// Walk all dogs
			} else if (choice.equalsIgnoreCase("4")) {
				currentShelter.inputWalkAll();
				currentShelter.tick();
				System.out.println(
						"The dogs seem to be happy to go out, barking and shouting about syntax errors as they go.");
			}

			// Play
			else if (choice.equalsIgnoreCase("5")) {

				// Picking pet to play with
				System.out.println("Which pet do you want to play with? (Type its name)");
				String playingPet = input.nextLine();

				// Cycling through current pets to find the one to play with
				for (VirtualPet currentPet : pets) {
					if (currentPet.getName().equalsIgnoreCase(playingPet)) {
						currentPet.inputPlay();
						currentShelter.tick();

						System.out.println("\n" + currentPet.getName() + " chases his own tail as you mysteriously");
						System.out.println("find yourself pulling out a laser pointer and moving");
						System.out.println("it in circles, out of your own accord.\n");
					}
				}

				// Put to bed
			} else if (choice.equalsIgnoreCase("6")) {
				currentShelter.inputSleepAll();
				currentShelter.tick();

				System.out.println(
						"\nLights out! All of the pets scuffle in full resting position. Including the robotics. Somehow.");
				System.out
						.println("They all wake up later, feeling refreshed, raucously reminding you to feed them.\n ");

				// Do nothing
			} else if (choice.equalsIgnoreCase("7")) {
				currentShelter.tick();
				System.out.println("\nYour pets seem to be making more and more noise,");
				System.out.println("reminding you to do your job.\n");

				// Take in a pet

				// Shelter is Full

			} else if (choice.equalsIgnoreCase("8")) {
				currentShelter.tick();
				System.out.println("\nLook at you, being proactive!");
				if (pets.size() >= 5) {
					System.out.println("We like the enthusiasm, but we're out of room!\n");

					// Shelter has room

				} else {
					System.out.println(
							"You step outside for no more than a few nanoseconds, only to find a stray animal on the doorstep.\n");

					// New Pet Config

					// Choosing type of animal
					System.out.println("What kind of pet is it? (Type 'RoboCat', 'RoboDog', 'OrgCat', or 'OrgDog'");
					String typeChoice = input.nextLine();

					// OrgDog
					if (typeChoice.equalsIgnoreCase("OrgDog")) {
						System.out.println("What's its new name?");
						String newPetName = input.nextLine();
						System.out.println("What's it like? (Add a description)");

						String newPetDescription = input.nextLine();

						if (pets.size() == 0) {
							pet1 = new OrganicDog(newPetName, newPetDescription);
							currentShelter.addPet(pet1);
						} else if (pets.size() == 1) {
							pet2 = new OrganicDog(newPetName, newPetDescription);
							currentShelter.addPet(pet2);
						} else if (pets.size() == 2) {
							pet3 = new OrganicDog(newPetName, newPetDescription);
							currentShelter.addPet(pet3);
						} else if (pets.size() == 3) {
							pet4 = new OrganicDog(newPetName, newPetDescription);
							currentShelter.addPet(pet4);
						} else if (pets.size() == 4) {
							pet5 = new OrganicDog(newPetName, newPetDescription);
							currentShelter.addPet(pet5);
						}
						System.out.println("\nLooks like " + newPetName + " is ready to make some new friends!\n");

						// OrgCat
					} else if (typeChoice.equalsIgnoreCase("OrgCat")) {
						System.out.println("What's its new name?");
						String newPetName = input.nextLine();
						System.out.println("What's it like? (Add a description)");

						String newPetDescription = input.nextLine();
						if (pets.size() == 0) {
							pet1 = new OrganicCat(newPetName, newPetDescription);
							currentShelter.addPet(pet1);
						} else if (pets.size() == 1) {
							pet2 = new OrganicCat(newPetName, newPetDescription);
							currentShelter.addPet(pet2);
						} else if (pets.size() == 2) {
							pet3 = new OrganicCat(newPetName, newPetDescription);
							currentShelter.addPet(pet3);
						} else if (pets.size() == 3) {
							pet4 = new OrganicCat(newPetName, newPetDescription);
							currentShelter.addPet(pet4);
						} else if (pets.size() == 4) {
							pet5 = new OrganicCat(newPetName, newPetDescription);
							currentShelter.addPet(pet5);
						}
						System.out.println("\nLooks like " + newPetName + " is ready to make some new friends!\n");
						
						// RoboDog
					} else if (typeChoice.equalsIgnoreCase("RoboDog")) {
						System.out.println("What's its new name?");
						String newPetName = input.nextLine();
						System.out.println("What's it like? (Add a description)");

						String newPetDescription = input.nextLine();
						if (pets.size() == 0) {
							pet1 = new RoboDog(newPetName, newPetDescription);
							currentShelter.addPet(pet1);
						} else if (pets.size() == 1) {
							pet2 = new RoboDog(newPetName, newPetDescription);
							currentShelter.addPet(pet2);
						} else if (pets.size() == 2) {
							pet3 = new RoboDog(newPetName, newPetDescription);
							currentShelter.addPet(pet3);
						} else if (pets.size() == 3) {
							pet4 = new RoboDog(newPetName, newPetDescription);
							currentShelter.addPet(pet4);
						} else if (pets.size() == 4) {
							pet5 = new RoboDog(newPetName, newPetDescription);
							currentShelter.addPet(pet5);
						}
						System.out.println("\nLooks like " + newPetName + " is ready to make some new friends!\n");
						
						// RoboCat
					} else if (typeChoice.equalsIgnoreCase("RoboCat")) {
						System.out.println("What's its new name?");
						String newPetName = input.nextLine();
						System.out.println("What's it like? (Add a description)");

						String newPetDescription = input.nextLine();
						if (pets.size() == 0) {
							pet1 = new RoboCat(newPetName, newPetDescription);
							currentShelter.addPet(pet1);
						} else if (pets.size() == 1) {
							pet2 = new RoboCat(newPetName, newPetDescription);
							currentShelter.addPet(pet2);
						} else if (pets.size() == 2) {
							pet3 = new RoboCat(newPetName, newPetDescription);
							currentShelter.addPet(pet3);
						} else if (pets.size() == 3) {
							pet4 = new RoboCat(newPetName, newPetDescription);
							currentShelter.addPet(pet4);
						} else if (pets.size() == 4) {
							pet5 = new RoboCat(newPetName, newPetDescription);
							currentShelter.addPet(pet5);
						}
						System.out.println("\nLooks like " + newPetName + " is ready to make some new friends!\n");

					}

				}
			}

			// Release Pet
			else if (choice.equalsIgnoreCase("9")) {

				System.out.println("Which pet do you want to release? (Type its name)");
				String releasingPet = input.nextLine();

				List<VirtualPet> toRemove = new ArrayList<>();
				for (VirtualPet activePet : currentShelter.getShelterPetVariables()) {
					if (activePet.getName().equalsIgnoreCase(releasingPet)) {
						toRemove.add(activePet);
						System.out.println("\nAs you stop to take a look at " + activePet.getName()
								+ ", a happy family walks in and decides to adopt it on the spot!");
						System.out.println("You're glad to see it go. He was getting on your nerves anyway. *sniff*\n");
					}

				}

				currentShelter.getShelterPetVariables().removeAll(toRemove);

			}

			// Quit
			else if (choice.equalsIgnoreCase("10")) {
				System.out.println("\nTime to clock out! Nice treats from your relief await!");
				input.close();
				System.exit(0);

				continue;
			}
		}
	}
}
