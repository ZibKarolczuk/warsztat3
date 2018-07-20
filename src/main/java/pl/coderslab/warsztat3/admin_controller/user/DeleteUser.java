package pl.coderslab.warsztat3.admin_controller.user;

import pl.coderslab.warsztat3.dao.UserDao;
import pl.coderslab.warsztat3.dao.UserGroupDao;
import pl.coderslab.warsztat3.dao.UsersDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteUser", urlPatterns = "/deleteUser")
public class DeleteUser extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final String userId = request.getParameter("id");

        try {
            UsersDao.deleteUser(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("./readUs");


    }
}
