package pl.pjatk.jaz.session;

import pl.pjatk.jaz.HashPassword;
import pl.pjatk.jaz.webapp.UserToDatabase;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped
public class RegisterController
{
    @Inject
    private RegistrationRequest registrationRequest;

    @Inject
    UserToDatabase userToDatabase = new UserToDatabase();

    private HashPassword hashPassword = new HashPassword();

    public String register() //
    {
        String hashedPassword = hashPassword.hash(registrationRequest.getPassword()); //hashing password


        if(userToDatabase.checkIfNickIsUnique(registrationRequest.getUsername()))
        {
            if(userToDatabase.checkIfEmailIsUnique(registrationRequest.getUserEmail()))
            {
                if (registrationRequest.getSecPassword().equals(registrationRequest.getPassword()))
                {
                    userToDatabase.addUserToDb(registrationRequest.getName(), registrationRequest.getLastName(), registrationRequest.getUsername(),
                            hashedPassword, registrationRequest.getUserEmail(), registrationRequest.getDateOfBirth());

                    return "/index.xhtml?faces-redirect=true";
                }
                else
                {
                    System.out.println("Passwords doesn't match: " + registrationRequest.getPassword() + "!=" + registrationRequest.getSecPassword());
                    return "/register.xhtml?faces-redirect=true";
                }
            }
            else
                return "/register.xhtml?faces-redirect=true";
        }
        else
        {
            return "/register.xhtml?faces-redirect=true";
        }
    }
}
