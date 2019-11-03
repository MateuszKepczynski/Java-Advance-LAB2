package pl.pjatk.jaz.registration;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class HashPassword
{
    public String hash(String userPassword)
    {
        var passwordEncoder = new BCryptPasswordEncoder();

        final String hashedUserPass = passwordEncoder.encode(userPassword);

        return hashedUserPass;
    }

    public boolean deHash(String userPss, String hashedPass)
    {
        var passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(userPss,hashedPass);
    }
}
