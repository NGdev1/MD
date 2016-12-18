package ru.ProPoisk.servlets;

import ru.ProPoisk.models.User;
import ru.ProPoisk.DAO.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 18.10.16.
 */

@WebServlet("/admin")

public class Admin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if(session.getAttribute("user") == null) {
            resp.sendRedirect("/login");
            return;
        }

        if("delete".equals(req.getParameter("action"))){
            System.out.println("deleting!");
            String id = req.getParameter("id");

            if(id != null){
                try {
                    UserDaoImpl.getInstance().deleteUser(Integer.valueOf(id));
                } catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        }

        List<User> users = new ArrayList<>();
        try {
            users = UserDaoImpl.getInstance().getAll();
        } catch (SQLException e) {
            System.out.println("Error getting all users: " + e.getMessage());
        }
        req.setAttribute("Users", users);

        getServletConfig().getServletContext().getRequestDispatcher("/admin.ftl").forward(req, resp);
    }
}
