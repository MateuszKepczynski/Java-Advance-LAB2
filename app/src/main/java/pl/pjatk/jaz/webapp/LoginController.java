package pl.pjatk.jaz.webapp;

import pl.pjatk.jaz.UserMapBean;
import pl.pjatk.jaz.login.LoginRequest;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;

@Named
@RequestScoped
public class LoginController implements Serializable
{
    FacesContext context = FacesContext.getCurrentInstance();

    @Inject
    private LoginRequest loginRequest;

    @Inject
    UserMapBean userMapBean;

    User admin = new User("","admin","admin","admin","","","");

    public void login()
    {
        userMapBean.add(admin);

        if(userMapBean.ifThereIs(loginRequest.getUsername()))
        {
            if(userMapBean.doesPasswordMatch(loginRequest.getUsername(), loginRequest.getPassword()))
            {
                System.out.println("/index.xhtml?faces-redirect=true");
            }
        }
    }

    public void register()
    {
        try
        {
            context.getExternalContext().redirect("register.xhtml");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
