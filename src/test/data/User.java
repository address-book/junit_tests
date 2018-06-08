package test.data;

import com.github.javafaker.Faker;

public class User {
    private String email;
    private String password;

    public static User validUser() {
        User user = new User();

        user.email = "user@example.com";
        user.password = "password";

        return user;
    }

    public static User invalidUser() {
        return new User();
    }

    public static User randomUser() {
        return new User();
    }

    public User() {
        Faker faker = new Faker();
        this.email = faker.internet().emailAddress();
        this.password = faker.internet().password();
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}

