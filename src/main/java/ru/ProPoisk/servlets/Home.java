package ru.ProPoisk.servlets;

import ru.ProPoisk.DAO.FeedItemDao;
import ru.ProPoisk.DAO.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/profile")

/**
 * Created by apple on 27.09.16.
 */

public class Home extends HttpServlet {

    private FeedItemDao feedItemDao;

    @Override
    public void init() throws ServletException {
        feedItemDao = FeedItemDao.getInstance();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (session.getAttribute("user") == null) {
            resp.sendRedirect("login");
            return;
        }
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if ("logout".equals(req.getParameter("action"))) {
            req.getSession().removeAttribute("user");
            resp.sendRedirect("login");
            return;
        }

        if (session.getAttribute("user") == null) {
            resp.sendRedirect("login");
            return;
        }

        User user = (User) session.getAttribute("user");
        req.setAttribute("name", user.getName());
        req.setAttribute("city", user.getCity());

        try {
            req.setAttribute("feed", feedItemDao.getAllFeedFromUser(user.getId()));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if("get_news".equals(req.getParameter("action"))){
            getServletConfig().getServletContext().getRequestDispatcher("/get_user_news.ftl").forward(req, resp);
            return;
        }

        getServletConfig().getServletContext().getRequestDispatcher("/profile.ftl").forward(req, resp);
    }
}
