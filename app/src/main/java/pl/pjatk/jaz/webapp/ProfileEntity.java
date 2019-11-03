package pl.pjatk.jaz.webapp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "profile")
public class ProfileEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String lastName;
    private String username;
    private String password;
    private String userEmail;
    private String dateOfBirth;


    public ProfileEntity(String name, String lastName, String nickname, String password, String userEmail, String dateOfBirth)
    {
        this.name = name;
        this.lastName = lastName;
        this.username = nickname;
        this.password = password;
        this.userEmail = userEmail;
        this.dateOfBirth = dateOfBirth;
    }

    public ProfileEntity()
    {
        this.name = "";
        this.lastName = "";
        this.username = "";
        this.password = "";
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

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }
}