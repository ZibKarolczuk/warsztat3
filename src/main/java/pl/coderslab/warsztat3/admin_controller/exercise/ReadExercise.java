package pl.coderslab.warsztat3.admin_controller.exercise;

import pl.coderslab.warsztat3.dao.ExerciseDao;
import pl.coderslab.warsztat3.model.Exercise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ReadExercise", urlPatterns = {"/readEx"})
public class ReadExercise extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List<Exercise> listExercises = ExerciseDao.loadAll();
            request.setAttribute("exercises", listExercises);

            getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/admin/exercises/readEx.jsp")
                    .forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
