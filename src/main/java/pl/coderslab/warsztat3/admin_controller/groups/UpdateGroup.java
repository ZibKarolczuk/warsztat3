package pl.coderslab.warsztat3.admin_controller.groups;

import pl.coderslab.warsztat3.dao.UserGroupDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UpdateGroup", urlPatterns = "/updateGr")
public class UpdateGroup extends HttpServlet {

    private String groupId;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        final String editedName = request.getParameter("editedName");

        try {
            UserGroupDao.editGroup(groupId, editedName);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("./readGr");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        groupId = request.getParameter("id");
        final String groupName = request.getParameter("group");

        request.setAttribute("groupId", groupId);
        request.setAttribute("groupName", groupName);

        getServletContext()
                .getRequestDispatcher("/WEB-INF/views/admin/groups/updateGr.jsp")
                .forward(request, response);

    }
}
