package pl.pjatk.jaz.webapp;

import pl.pjatk.jaz.UserMapBean;
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

    public void register()
    {
        User user = new User(registrationRequest.getName(),registrationRequest.getLastName(),registrationRequest.getUsername()
                ,registrationRequest.getPassword(),registrationRequest.getSecPassword(),registrationRequest.getUserEmail(),registrationRequest.getDateOfBirth());
        userMapBean.add(user);
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
