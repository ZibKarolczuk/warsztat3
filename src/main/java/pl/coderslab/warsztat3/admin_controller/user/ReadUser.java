package pl.coderslab.warsztat3.admin_controller.user;

import pl.coderslab.warsztat3.dao.UserDao;
import pl.coderslab.warsztat3.dao.UserGroupDao;
import pl.coderslab.warsztat3.dao.UsersDao;
import pl.coderslab.warsztat3.model.User;
import pl.coderslab.warsztat3.model.UserGroup;
import pl.coderslab.warsztat3.model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ReadUser", urlPatterns = {"/readUs"})
public class ReadUser extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List<User> listUsers = UserDao.loadAll();
            request.setAttribute("users", listUsers);

            getServletContext()
                    .getRequestDispatcher("/WEB-INF/views/admin/users/readUs.jsp")
                    .forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
