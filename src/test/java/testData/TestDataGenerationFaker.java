package testData;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestDataGenerationFaker {

    Faker faker = new Faker(new Locale("ru_RU"));

    public String
            firstName = faker.name().firstName(),
            phoneNumber = faker.phoneNumber().subscriberNumber(10),
            companyName = faker.company().name(),
            message = faker.chuckNorris().fact();
}
