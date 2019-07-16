package org.wq.demo.springclouddemo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author wangqiang26
 * @mail wangqiang26@jd.com
 * @Date 16:02 2018/12/11
 */
@WebServlet("/MyServlet")
public class TestServlet extends HttpServlet {

    private String message;

    @Override
    public void init() throws ServletException
    {
        message = "Hello World";
    }

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException
    {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
    }

    @Override
    public void destroy()
    {

    }

}
