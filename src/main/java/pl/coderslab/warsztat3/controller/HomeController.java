package pl.coderslab.warsztat3.controller;

import pl.coderslab.warsztat3.dao.SolutionDao;
import pl.coderslab.warsztat3.model.Solution;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "HomeController", urlPatterns = {"/"})
public class HomeController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List<Solution> listLastSolutions = SolutionDao.loadAll(Integer.parseInt(this.getServletContext().getInitParameter("number-solutions")));
            request.setAttribute("lastSolutions", listLastSolutions);

            getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/index.jsp")
                    .forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
