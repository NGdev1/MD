package ru.ProPoisk.servlets;

import ru.ProPoisk.DAO.UserDao;
import ru.ProPoisk.models.User;
import ru.ProPoisk.DAO.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * Created by Михаил on 13.11.2016.
 */

@WebServlet("/contacts")

public class Contacts extends HttpServlet {
    UserDao userDao;

    @Override
    public void init() throws ServletException {
        userDao = UserDaoImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        User user = (User) session.getAttribute("user");

        User[] users = new User[0];
        try {
            users = userDao.getAll();
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        int userId = user.getId();
        PrintWriter writer = resp.getWriter();

        if("add_friend".equals(action)){
            try {
                int friendId = Integer.valueOf(req.getParameter("friendId"));
                userDao.addFriend(userId, friendId);

                writer.write("success");
            } catch (Exception e){
                System.out.println("Error adding a friend to user: " + e.getMessage());

                writer.write("Ошибка при добавлении в контакты: " + e.getMessage());
            }
        } else if ("remove_friend".equals(action)){
            try {
                int friendId = Integer.valueOf(req.getParameter("friendId"));
                userDao.removeFriend(userId, friendId);

                writer.write("success");
            } catch (Exception e){
                System.out.println("Error deleting a friend: " + e.getMessage());

                writer.write("Ошибка при удалении из контактов: " + e.getMessage());
            }
        }
    }
}
