package test.data;


import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Map;

public class UserData {
    private String email;
    private String password;

    public static UserData validUser() {
        Map<String, String> data = new HashMap<String, String>();
        data.put("email", "user@example.com");
        data.put("password", "password");

        return new UserData(data);
    }

    public static UserData randomUser() {
        Map<String, String> data = new HashMap<String, String>();

        return new UserData(data);
    }

    public UserData(Map<String, String> data) {
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
