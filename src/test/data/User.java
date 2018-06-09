package test.data;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Map;

public class User {
    private String email;
    private String password;

    public static User validUser() {
        Map<String, String> data = new HashMap<String, String>();
        data.put("email", "user@example.com");
        data.put("password", "password");
        return new User(data);
    }

    public static User blankPassword() {
        Map<String, String> data = new HashMap<String, String>();
        data.put("password", "");
        return new User(data);
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

    public User(Map<String, String> data) {
        email = data.get("email");
        password = data.get("password");

        Faker faker = new Faker();
        this.email = (email != null) ? email : faker.internet().emailAddress();
        this.password = (password != null) ? password : faker.internet().password();
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}

