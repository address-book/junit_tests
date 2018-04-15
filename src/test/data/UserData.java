package test.data;


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

    private UserData(Map<String, String> data) {
        this.email = data.get("email");
        this.password = data.get("password");
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
