package pl.pjatk.jaz.webapp;

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

    public void register()
    {
        String hashedPassword;
        hashedPassword = hashPassword.hash(registrationRequest.getPassword());

        User user = new User(registrationRequest.getName(),registrationRequest.getLastName(),
                registrationRequest.getUsername(),hashedPassword,
                registrationRequest.getSecPassword(),registrationRequest.getUserEmail(),
                registrationRequest.getDateOfBirth());userMapBean.add(user);

        UserToDatabase userToDatabase = new UserToDatabase();

        userToDatabase.addUserToDb(user);

        try
        {
            context.getExternalContext().redirect("login.xhtml");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
