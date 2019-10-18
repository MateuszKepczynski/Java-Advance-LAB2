package pl.pjatk.jaz.registration;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class RegistrationRequest
{
    private String name;
    private String lastName;
    private String username;
    private String password;
    private String secPassword;
    private String userEmail;
    private String dateOfBirth;

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSecPassword(String secPassword) {
        this.secPassword = secPassword;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getSecPassword() {
        return secPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }
}
