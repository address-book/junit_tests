package test.data;

import com.github.javafaker.Faker;

import java.util.HashMap;
import java.util.Map;

public class UserData {

    private Faker faker = new Faker();

    public Map<String, String> newUser() {
        Map<String, String> data = new HashMap<String, String>();
        data.put("emailAddress", faker.internet().emailAddress());
        data.put("password", faker.internet().password());
        return data;
    }

    public Map<String, String> validUser() {
        Map<String, String> data = new HashMap<String, String>();
        data.put("email", "saucecon@example.com");
        data.put("password", "password");
        return data;
    }

}