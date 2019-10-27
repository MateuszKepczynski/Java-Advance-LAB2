package pl.pjatk.jaz.webapp;

import pl.pjatk.jaz.UserMapBean;
import pl.pjatk.jaz.login.LoginRequest;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.Serializable;

@Named
@ManagedBean
@ApplicationScoped
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

    public String register()
    {
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("username", "creatingUser");
            return "true";
    }


    public String validateUsernamePassword()
    {
        boolean valid = false;
        String pass;

        userMapBean.add(admin);
        if(userMapBean.ifThereIs(loginRequest.getUsername()))
        {
            if(userMapBean.doesPasswordMatch(loginRequest.getUsername(), loginRequest.getPassword()))
            {
                valid = true;
            }
        }

        if (valid)
        {
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("username", loginRequest.getUsername());
            pass= "true";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username or Passowrd",
                            "Please enter correct username and Password"));
            pass = "false";
        }
        return pass;
    }

    //logout event, invalidate session
    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "true";
    }
}