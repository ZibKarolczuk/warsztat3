package pl.coderslab.warsztat3.admin_controller.groups;

import pl.coderslab.warsztat3.dao.UserGroupDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CreateGroup", urlPatterns = "/createGr")
public class CreateGroup extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final String group = request.getParameter("group");

        try {
            UserGroupDao.createGroup(group);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("./readGr");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext()
                .getRequestDispatcher("/WEB-INF/views/admin/groups/createGr.jsp")
                .forward(request, response);

    }
}
