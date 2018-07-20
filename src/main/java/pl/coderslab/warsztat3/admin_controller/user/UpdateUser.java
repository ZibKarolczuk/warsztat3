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

@WebServlet(name = "UpdateUser", urlPatterns = "/updateUs")
public class UpdateUser extends HttpServlet {

    private String userId;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final String editedName = request.getParameter("editedName");
        final String editedEmail = request.getParameter("editedEmail");
        final String editedGroup = request.getParameter("user_group");

        try {
            UsersDao.editUser(Integer.parseInt(userId), editedName, editedEmail, editedGroup);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("./readUs");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        userId = request.getParameter("id");
        final String userName = request.getParameter("user");
        final String email = request.getParameter("email");
        final String group = request.getParameter("group");

        try {
            List<UserGroup> listUserGroup = UserGroupDao.loadAll();
            request.setAttribute("groups", listUserGroup);
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("userId", userId);
        request.setAttribute("userName", userName);
        request.setAttribute("email", email);
        request.setAttribute("group", group);

        getServletContext()
                .getRequestDispatcher("/WEB-INF/views/admin/users/updateUs.jsp")
                .forward(request, response);

    }
}
