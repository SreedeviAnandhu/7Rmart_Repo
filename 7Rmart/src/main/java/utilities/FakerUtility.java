package utilities;

import com.github.javafaker.Faker;

public class FakerUtility {

	Faker faker = new Faker();

	public String generateName() {

		return faker.name().firstName();

	}

	public String generateAddress() {

		return faker.address().fullAddress();
	}

	public int generateRandomNumber() {

		return faker.number().randomDigit();
	}

	public String generatRandomEmail() {

		return faker.internet().emailAddress();
	}

	public String generatePassword() {

		return faker.random().toString();
	}

}
