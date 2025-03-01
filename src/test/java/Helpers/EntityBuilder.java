package Helpers;

import Helpers.Entities.Address;
import Helpers.Entities.User;
import com.github.javafaker.Faker;

public class EntityBuilder {
    private static final Faker faker = new Faker();

    public static User GetUser() {
        return User.builder()
                .FirstName(faker.name().firstName())
                .LastName(faker.name().lastName())
                .Email(faker.internet().emailAddress())
                .Password(faker.internet().password())
                .build();
    }

    public static Address GetAddress() {
        return Address.builder()
                .Country("Canada")
                .City(faker.country().capital())
                .Street(faker.address().streetAddress())
                .PostalCode(faker.address().zipCode())
                .PhoneNumber(faker.phoneNumber().phoneNumber())
                .build();
    }
}
