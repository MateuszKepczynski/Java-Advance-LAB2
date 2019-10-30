package pl.pjatk.jaz;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.pjatk.jaz.webapp.User;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;

@ApplicationScoped
public class UserMapBean
{
    HashMap<String,User> userHashMap = new HashMap<>(); //Simple database

    public void add(User user) //adding user to hashMap
    {
        userHashMap.put(user.getUsername(),user);
    }

    public String getUsername(String username) //getting nickname from hashMap
    {
        return userHashMap.get(username).getUsername();
    }

    public boolean ifThereIs(String username) //checking if there's key using "String username"
    {
        return username.equals(userHashMap.get(username).getUsername());
    }

    public boolean doesPasswordMatch(String username, String password) //checking that password match
    {
        var passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(password, userHashMap.get(username).getPassword());
    }
}