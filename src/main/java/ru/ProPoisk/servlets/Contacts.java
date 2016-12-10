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

/**
 * Created by Михаил on 13.11.2016.
 */

@WebServlet("/contacts")

public class Contacts extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        User user = (User) session.getAttribute("user");

        User[] users = new User[0];
        try {
            users = UserDaoImpl.getInstance().getAll();
        } catch (SQLException e) {
            System.out.println("Error getting all users: " + e.getMessage());
        }

        User[] friends = new User[0];
        try {
            friends = UserDaoImpl.getInstance().getFriends(user.getId());
        } catch (SQLException e) {
            System.out.println("Error getting friends: " + e.getMessage());
        }

        req.setAttribute("Users", users);
        req.setAttribute("Friends", friends);

        getServletConfig().getServletContext().getRequestDispatcher("/contacts.ftl").forward(req, resp);
    }
}
