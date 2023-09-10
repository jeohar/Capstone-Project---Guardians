package tek.sdet.framework.utilities;

import java.util.HashSet;
import java.util.Set;

import com.github.javafaker.Faker;

public class DataGenerator {

	public static String addressGenerator(String input) {

		Faker faker = new Faker();

		String output = "";

		if (input.equalsIgnoreCase("countryValue")) {
			output = "United States";
		} else if (input.equalsIgnoreCase("fullnameValue")) {
			output = faker.name().fullName();
		} else if (input.equalsIgnoreCase("PhoneValue")) {
			output = faker.phoneNumber().cellPhone();
		} else if (input.equalsIgnoreCase("stAddress")) {
			output = faker.address().streetAddress();
		} else if (input.equalsIgnoreCase("aptValue")) {
			output = faker.address().secondaryAddress();
		} else if (input.equalsIgnoreCase("cityValue")) {
			output = faker.address().city();
		} else if (input.equalsIgnoreCase("stateValue")) {
			output = faker.address().state();
		} else if (input.equalsIgnoreCase("zipCodeValue")) {
			String zipcode = faker.address().zipCode().substring(0, 5);
			output = zipcode;
		}
		return output;

	}

	public static Set<String> gAdd = new HashSet<>();

	public static String getAdressLine() {

		String phoneNumber = "202";

		for (int i = 0; i < 7; i++) {
			phoneNumber += (int) (Math.random() * 10);
			if (!gAdd.contains(phoneNumber)) {
				gAdd.add(phoneNumber);

			}
		}
		return phoneNumber;

	}

	public static String getEmail() {
		String prefix = "hasib";
		String provider = "@tekschool.us";
		int random = (int) (Math.random() * 10000);
		String email = prefix + random + provider;
		return email;
	}

	public static String RandomPhoneNumber() {
		String phoneNumber = "";

		int areaCode = (int) (Math.random() * 800) + 200; // Generate area code between 200 and 999
		phoneNumber += areaCode;

		for (int i = 0; i < 7; i++) { // 3 area code + 7 phone number
			int phoneNumberDigit = (int) (Math.random() * 10);
			phoneNumber += phoneNumberDigit;
		}

		return phoneNumber;
	}

	public static String cardNumber() {
		String cardNumber = "";

		for (int i = 0; i < 16; i++) { // 3 area code + 7 phone number
			int phoneNumberDigit = (int) (Math.random() * 10);
			cardNumber += phoneNumberDigit;
		}

		return cardNumber;
	}

}
