package by.du.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String username = req.getParameter("username");
        final String password = req.getParameter("password");
        if ("admin".equals(username) && "pass".equals(password)) {
            resp.addCookie(new Cookie("isLogged", "true"));
            resp.sendRedirect("/local/security/ip");
        } else {
            resp.setStatus(401);
            resp.getWriter().write("invalid username or password");
        }

    }
}
