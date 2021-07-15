package by.du.controller;

import by.du.model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@WebServlet("/")
public class TableController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        extracted(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        extracted(req, resp);
    }

    private void extracted(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Cars");

        final List<Car> cars;

        final Map<String, String[]> parameterMap = req.getParameterMap();

        if (req.getParameter("flexCheckDefault") != null) {
            System.out.println(req.getParameter("cars"));
        }

        if (req.getParameter("reload") != null) {
            final Car x1 = Car.builder()
                    .brand("bmw")
                    .model("x1")
                    .price(100)
                    .build();
            final Car x2 = Car.builder()
                    .brand("bmw")
                    .model("x2")
                    .price(200)
                    .build();
            final Car x3 = Car.builder()
                    .brand("bmw")
                    .model("x3")
                    .price(300)
                    .build();

            cars = Arrays.asList(x1, x2, x3);
        } else {
            cars = Collections.emptyList();
        }

        req.setAttribute("cars", cars);
        req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
    }
}
