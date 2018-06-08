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
        User user = new User();

        user.email = "notauser@example.com";
        user.password = "password";

        return user;
    }

    public static User randomUser() {
        User user = new User();

        Faker faker = new Faker();
        user.email = faker.internet().emailAddress();
        user.password = faker.internet().password();

        return user;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}

