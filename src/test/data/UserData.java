package test.data;

import java.util.HashMap;
import java.util.Map;

public class UserData {

    public Map<String, String> validUser() {
        Map<String, String> data = new HashMap<String, String>();
        data.put("email", "saucecon@example.com");
        data.put("password", "password");
        return data;
    }
}

