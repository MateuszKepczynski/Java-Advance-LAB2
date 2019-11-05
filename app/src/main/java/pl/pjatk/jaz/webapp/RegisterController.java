package pl.pjatk.jaz.webapp;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.pjatk.jaz.registration.HashPassword;
import pl.pjatk.jaz.registration.RegistrationRequest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class RegisterController
{
    @Inject
    private RegistrationRequest registrationRequest;

    @Inject
    UserToDatabase userToDatabase = new UserToDatabase();

    HashPassword hashPassword = new HashPassword();

    public boolean register() //
    {
        String hashedPassword;
        hashedPassword = hashPassword.hash(registrationRequest.getPassword()); //hashing password

        if(userToDatabase.checkIfNickIsUnique(registrationRequest.getUsername()))
        {
            if(userToDatabase.checkIfEmailIsUnique(registrationRequest.getUserEmail()))
            {
                if (registrationRequest.getSecPassword().equals(registrationRequest.getPassword()))
                {
                    userToDatabase.addUserToDb(registrationRequest.getName(), registrationRequest.getLastName(), registrationRequest.getUsername(),
                            hashedPassword, registrationRequest.getUserEmail(), registrationRequest.getDateOfBirth());

                    return true;
                }
                else
                {
                    System.out.println("Passwords doesn't match: " + registrationRequest.getPassword() + "!=" + registrationRequest.getSecPassword());
                    return false;
                }
            }
            else
                return false;
        }
        else
        {
            return false;
        }
    }
}
