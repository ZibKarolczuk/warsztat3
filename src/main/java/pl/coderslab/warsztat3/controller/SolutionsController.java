package pl.coderslab.warsztat3.controller;

import pl.coderslab.warsztat3.dao.UserDao;
import pl.coderslab.warsztat3.dao.UsersDao;
import pl.coderslab.warsztat3.model.User;
import pl.coderslab.warsztat3.model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "SolutionsController", urlPatterns = {"/solutions"})
public class SolutionsController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            //TODO change to solution display instead of groups

            final String idUser = request.getParameter("id");
            final String username = request.getParameter("username");
            final String email = request.getParameter("email");

            List<User> solutionsList = UserDao.loadById(Integer.parseInt(idUser));
            request.setAttribute("solutions", solutionsList);
            request.setAttribute("username", username);
            request.setAttribute("email", email);
            getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/solutions.jsp")
                    .forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
