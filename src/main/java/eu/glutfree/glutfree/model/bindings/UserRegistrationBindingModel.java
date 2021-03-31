package eu.glutfree.glutfree.model.bindings;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;

public class UserRegistrationBindingModel {
    public String username;
    public String password;
    public String confirmPassword;
    public String email;

    public UserRegistrationBindingModel() {
    }

    @Length(min =2 , message = "Username length must be min two chars")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Length(min = 3 , message = "Password length must be min three chars")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Email(message = "Enter valid email address")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
