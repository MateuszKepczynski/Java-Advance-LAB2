package pl.pjatk.jaz;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("hello") //test
public class AverageServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        float average;
        resp.setStatus(200);

        PrintWriter respWriter = resp.getWriter();
        respWriter.println("Below is your result of average:");

        String queryString = req.getParameter("average");


        if(queryString == null)
        {
            respWriter.println("Below is your result of average:");
        }
        else
        {
            average = CalculateAverage.doAverage(queryString);
            respWriter.println(average);
        }

    }
}