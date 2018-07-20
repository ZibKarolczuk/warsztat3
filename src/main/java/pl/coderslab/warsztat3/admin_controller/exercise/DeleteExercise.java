package pl.coderslab.warsztat3.admin_controller.exercise;

import pl.coderslab.warsztat3.dao.ExerciseDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteExercise", urlPatterns = "/deleteEx")
public class DeleteExercise extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final String exerciseId = request.getParameter("id");

        try {
            ExerciseDao.deleteExercise(exerciseId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("./readEx");


    }
}
