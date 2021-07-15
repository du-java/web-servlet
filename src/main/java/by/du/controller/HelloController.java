package by.du.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String headerHost1 = req.getHeader("host");
        String headerHost2 = req.getHeader("Host");

        PrintWriter writer = resp.getWriter();
        writer.println("<title>HelloWorld</title>");
        writer.println("<body><h1>Hello World !!!</h1>");
        writer.println("<h1>Hello World !!!</h1></body>");
    }
}
