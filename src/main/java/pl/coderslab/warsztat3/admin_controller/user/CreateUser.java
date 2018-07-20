package pl.coderslab.warsztat3.admin_controller.user;

import pl.coderslab.warsztat3.dao.UserGroupDao;
import pl.coderslab.warsztat3.dao.UsersDao;
import pl.coderslab.warsztat3.model.UserGroup;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CreateUser", urlPatterns = "/createUs")
public class CreateUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final String username = request.getParameter("username");
        final String email = request.getParameter("email");
        final String password = request.getParameter("password");
        final int user_group_id = Integer.parseInt(request.getParameter("user_group"));

        try {
            UsersDao.createUser(username, email, password, user_group_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("./readUs");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            List<UserGroup> listUserGroup = UserGroupDao.loadAll();
            request.setAttribute("groups", listUserGroup);
        } catch (Exception e) {
            e.printStackTrace();
        }

        getServletContext()
                .getRequestDispatcher("/WEB-INF/views/admin/users/createUs.jsp")
                .forward(request, response);

    }
}
