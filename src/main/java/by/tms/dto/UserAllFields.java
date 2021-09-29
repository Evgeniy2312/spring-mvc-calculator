package by.tms.dto;

import by.tms.entity.User;
import by.tms.util.ErrorMessageManager;
import by.tms.util.PatternExpressions;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;



public class UserAllFields {

    @NotBlank()
    @Size(min = 3, max = 15, message = ErrorMessageManager.NAME_USER_ERROR)
    private String name;
    @NotBlank
    @Size(min = 3, max = 30)
    @Pattern(regexp = PatternExpressions.EMAIL_PATTERN, message = ErrorMessageManager.LOGIN_USER_ERROR)
    private String username;
    @NotBlank()
    @Size(min = 3, max = 15, message = ErrorMessageManager.PASSWORD_USER_ERROR)
    private String password;

    public UserAllFields(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public UserAllFields() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        UserAllFields userDTO = (UserAllFields) o;
        return Objects.equals(username, userDTO.username) && Objects.equals(password, userDTO.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

    public User getUser(UserAllFields userDTO){
        return new User(
                userDTO.getName(),
                userDTO.getUsername(),
                userDTO.getPassword()
        );
    }

}
