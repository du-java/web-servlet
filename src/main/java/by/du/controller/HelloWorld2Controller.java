package by.du.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello2")
public class HelloWorld2Controller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("<title>HelloWorld</title>");
        writer.println("<body><h1>Hello World 2!!!</h1>");
        writer.println("<h1>Hello World 2!!!</h1></body>");
    }
}
