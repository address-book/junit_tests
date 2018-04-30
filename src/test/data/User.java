package test.data;

public class User {
    private String email;
    private String password;

    public static User validUser() {
        User user = new User();

        user.email = "user@example.com";
        user.password = "password";

        return user;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}

