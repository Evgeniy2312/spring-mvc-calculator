package by.tms.dto;

import by.tms.entity.User;
import by.tms.util.ErrorMessageManager;
import by.tms.util.PatternExpressions;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

public class UserDTOByLogin {

    @NotBlank
    @Size(min = 3, max = 30)
    @Pattern(regexp = PatternExpressions.EMAIL_PATTERN, message = ErrorMessageManager.LOGIN_USER_ERROR)
    private String username;
    @NotBlank
    @Size(min = 3, max = 15, message = ErrorMessageManager.PASSWORD_USER_ERROR)
    private String password;

    public UserDTOByLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserDTOByLogin() {
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTOByLogin that = (UserDTOByLogin) o;
        return Objects.equals(username, that.username) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

    public User getUser(UserDTOByLogin userDTO){
        return new User(
                userDTO.getUsername(),
                userDTO.getPassword()
        );
    }
}
