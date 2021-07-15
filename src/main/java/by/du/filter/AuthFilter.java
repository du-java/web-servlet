package by.du.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/security/*")
public class AuthFilter extends HttpFilter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;

        final Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("isLogged".equals(cookie.getName()) && Boolean.parseBoolean(cookie.getValue())) {
                    chain.doFilter(req, res);
                    return;
                }
            }
        }
        isNotLogged(res);
    }

    private void isNotLogged(ServletResponse res) throws IOException {
        final HttpServletResponse response = (HttpServletResponse) res;
        response.setStatus(401);
        response.getWriter().write("Not logged");
    }
}
