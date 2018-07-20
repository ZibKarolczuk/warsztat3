package pl.coderslab.warsztat3.admin_controller.exercise;

import pl.coderslab.warsztat3.dao.ExerciseDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UpdateExercise", urlPatterns = "/updateEx")
public class UpdateExercise extends HttpServlet {

    private String exerciseId;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final String editedTitle = request.getParameter("editedTitle");
        final String editedDescription = request.getParameter("editedDescription");

        try {
            ExerciseDao.editExercise(Integer.parseInt(exerciseId), editedTitle, editedDescription);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("./readEx");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        exerciseId = request.getParameter("id");

        request.setAttribute("exerciseId", exerciseId);

        try {
            request.setAttribute("exerciseTitle", ExerciseDao.loadToEdit(exerciseId).getTitle());
            request.setAttribute("exerciseDescription", ExerciseDao.loadToEdit(exerciseId).getDescription());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        getServletContext()
                .getRequestDispatcher("/WEB-INF/views/admin/exercises/updateEx.jsp")
                .forward(request, response);

    }
}
