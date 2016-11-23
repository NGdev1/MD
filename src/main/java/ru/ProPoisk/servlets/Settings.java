package ru.ProPoisk.servlets;

import ru.ProPoisk.DAO.User;
import ru.ProPoisk.DAO.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Михаил on 13.11.2016.
 */

@WebServlet("/settings")

public class Settings extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        User user = (User) session.getAttribute("user");
        req.setAttribute("user", user);

        getServletConfig().getServletContext().getRequestDispatcher("/settings.ftl").forward(req, resp);
    }
}
