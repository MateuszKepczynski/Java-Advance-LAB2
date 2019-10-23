package pl.pjatk.jaz.login;

import javax.inject.Inject;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class JavFilter extends HttpFilter
{
    @Inject
    private UserSession userSession;

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException
    {
        if(req.getRequestURI().contains("/login"))
        {
            userSession.setState("123123ee");
            res.sendRedirect("http://google.com");
        }
        else
        {
            System.out.println("ww");
            chain.doFilter(req,res);
        }
    }
}
