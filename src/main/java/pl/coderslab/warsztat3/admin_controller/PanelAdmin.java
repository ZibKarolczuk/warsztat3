package pl.coderslab.warsztat3.admin_controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "PanelAdmin", urlPatterns = {"/panelAdmin"})
public class PanelAdmin extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext()
                .getRequestDispatcher("/WEB-INF/views/admin/panelAdmin.jsp")
                .forward(request, response);

    }
}
