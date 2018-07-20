package pl.coderslab.warsztat3.controller;

import pl.coderslab.warsztat3.dao.UsersDao;
import pl.coderslab.warsztat3.model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "UsersController", urlPatterns = {"/users"})
public class UsersController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            //TODO change to solution display instead of groups

            final String groupName = request.getParameter("group");
            final String idGroup = request.getParameter("id");

            List<Users> ugList = UsersDao.loadAllByGrupId(Integer.parseInt(idGroup));
            request.setAttribute("users", ugList);
            request.setAttribute("group", groupName);
            getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/users.jsp")
                    .forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
