package pl.pjatk.jaz.webapp;

public class User
{
    private String name;
    private String lastName;
    private String username;
    private String password;
    private String secPassword;
    private String userEmail;
    private String dateOfBirth;

    public User(String name, String lastName, String nickname, String password, String secPassword, String userEmail, String dateOfBirth) {
        this.name = name;
        this.lastName = lastName;
        this.username = nickname;
        this.password = password;
        this.secPassword = secPassword;
        this.userEmail = userEmail;
        this.dateOfBirth = dateOfBirth;
    }

    public User()
    {
        this.name = "";
        this.lastName = "";
        this.username = "";
        this.password = "";
        this.secPassword = "";
        this.userEmail = "";
        this.dateOfBirth = "";
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
}
