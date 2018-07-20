package pl.coderslab.warsztat3.controller;

import pl.coderslab.warsztat3.dao.SolutionDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "SolutionDetailsController", urlPatterns = {"/solution"})
public class SolutionDetailsController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            final String id = request.getParameter("id");

            String solutionDetails = SolutionDao.loadById(Integer.parseInt(id));
            request.setAttribute("solution", solutionDetails);
            getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/solution.jsp")
                    .forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
