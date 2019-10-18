package pl.pjatk.jaz.login;

import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@WebFilter("/*")
public class JavFilter extends HttpFilter
{
        /*
        if(req.getSession() != null)
        {
            res.sendRedirect("http://google.pl");
        }
    }
            if (req.getRequestURI().contains("/login"))
            {
                res.sendRedirect("http://google.pl");
                return;
            }
         */
}
