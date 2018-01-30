package data;

import com.github.javafaker.Faker;

public class AddressData {
    private static Faker faker = new Faker();

    private String firstName = faker.address().firstName();
    private String lastName = faker.address().lastName();
    private String streetAddress = faker.address().streetAddress();
    private String secondaryAddress = faker.address().secondaryAddress();
    private String city = faker.address().city();
    private String state = faker.address().state();
    private String zipCode = faker.address().zipCode();

    public AddressData() {
    }

    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public String getStreetAddress() {
        return this.streetAddress;
    }
    public String getSecondaryAddress() {
        return this.secondaryAddress;
    }
    public String getCity() {
        return this.city;
    }
    public String getState() {
        return this.state;
    }
    public String getZipCode() {
        return this.zipCode;
    }

}


