package pl.fiszki.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by Bartek on 24.04.2017.
 */
public class UserValidator {

    @Min(value = 4, message = "Login użytkownika musi mieć 4-20 znaków")
    @Max(value = 20, message = "Login użytkownika musi mieć 4-20 znaków")
    @NotNull
    private String username;

    @Min(value = 4, message = "Hasło użytkownika musi mieć 4-20 znaków")
    @Max(value = 20, message = "Hasło użytkownika musi mieć 4-20 znaków")
    @NotNull
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
