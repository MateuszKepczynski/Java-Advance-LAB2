package pl.pjatk.jaz.user;
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
    private String email;
    private String birthDay;


    public ProfileEntity(String name, String lastName, String nickname, String password, String userEmail, String dateOfBirth)
    {
        this.name = name;
        this.lastName = lastName;
        this.username = nickname;
        this.password = password;
        this.email = userEmail;
        this.birthDay = dateOfBirth;
    }

    public ProfileEntity()
    {
        this.name = "";
        this.lastName = "";
        this.username = "";
        this.password = "";
        this.email = "";
        this.birthDay = "";
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

    public String getEmail() {
        return email;
    }

    public String getBirthDay() {
        return birthDay;
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

    public void setEmail(String userEmail) {
        this.email = userEmail;
    }

    public void setBirthDay(String dateOfBirth) {
        this.birthDay = dateOfBirth;
    }

    public Long getId() {
        return id;
    }
}