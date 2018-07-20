package pl.coderslab.warsztat3.admin_controller.groups;

import pl.coderslab.warsztat3.dao.UserGroupDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteGroup", urlPatterns = "/deleteGr")
public class DeleteGroup extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final String groupId = request.getParameter("id");

        try {
            UserGroupDao.deleteGroup(groupId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("./readGr");


    }
}
