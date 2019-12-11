package pl.pjatk.jaz.session;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
public class UserSession implements Serializable
{
    private String state;

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }
}
