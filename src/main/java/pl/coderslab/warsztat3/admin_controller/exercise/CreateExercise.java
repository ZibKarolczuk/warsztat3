package pl.coderslab.warsztat3.admin_controller.exercise;

import pl.coderslab.warsztat3.dao.ExerciseDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CreateExercise", urlPatterns = "/createEx")
public class CreateExercise extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final String title = request.getParameter("title");
        final String description = request.getParameter("description");

        try {
            ExerciseDao.createExercise(title, description);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("./readEx");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext()
                .getRequestDispatcher("/WEB-INF/views/admin/exercises/createEx.jsp")
                .forward(request, response);

    }
}
