package pl.pjatk.jaz.webapp;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.pjatk.jaz.UserMapBean;
import pl.pjatk.jaz.registration.HashPassword;
import pl.pjatk.jaz.registration.RegistrationRequest;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;


@Named
@RequestScoped
public class RegisterController
{
    FacesContext context = FacesContext.getCurrentInstance();

    @Inject
    private RegistrationRequest registrationRequest;

    @Inject
    UserMapBean userMapBean;

    HashPassword hashPassword = new HashPassword();

    public boolean register()
    {
        String hashedPassword;
        hashedPassword = hashPassword.hash(registrationRequest.getPassword()); //hashing password

       // UserToDatabase userToDatabase = new UserToDatabase();

    //    userToDatabase.addUserToDb(registrationRequest.getName(),registrationRequest.getLastName(),registrationRequest.getUsername(),
        //          hashedPassword,registrationRequest.getUserEmail(),registrationRequest.getDateOfBirth()); // adding parameters from user to db
        if (registrationRequest.getSecPassword().equals(registrationRequest.getPassword())) {
            User user = new User(registrationRequest.getName(), registrationRequest.getLastName(),
                    registrationRequest.getUsername(), hashedPassword,
                    registrationRequest.getSecPassword(), registrationRequest.getUserEmail(),
                    registrationRequest.getDateOfBirth()); //useless in future updates, switching from hashmap to database

            userMapBean.add(user); // useless in future updates
            return true;
        } else {
            System.out.println("Passwords doesn't match: " + registrationRequest.getPassword() + "!=" + registrationRequest.getSecPassword());
            return false;
        }
    }

    public boolean passMatch(String password, String password2) //checking that password match to each other
    {
        var passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(password, password2); // matches password
    }
}
