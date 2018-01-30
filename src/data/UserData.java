package data;

import com.github.javafaker.Faker;

public class UserData {
    private static Faker faker = new Faker();

    private String emailAddress = faker.internet().emailAddress();
    private String password = faker.internet().password();

    public UserData() {
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public String getPassword() {
        return this.password;
    }
}


