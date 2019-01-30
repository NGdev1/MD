package ru.ProPoisk.servlets;

import ru.ProPoisk.models.FeedItem;
import ru.ProPoisk.DAO.FeedItemDao;
import ru.ProPoisk.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/feed")

/**

 */

public class Feed extends HttpServlet {

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

        User user = (User) session.getAttribute("user");
        String text = req.getParameter("text");

        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        FeedItem item = new FeedItem(user.getId(), text, myFormat.format(new Date()));

        PrintWriter pw = resp.getWriter();

        try {
            feedItemDao.addFeedItem(item);
        } catch (SQLException e) {
            pw.write("Sql ошибка!");
            e.printStackTrace();
            return;
        }

        pw.write("success");
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
            req.setAttribute("feed", feedItemDao.getAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if("get_news".equals(req.getParameter("action"))){
            getServletConfig().getServletContext().getRequestDispatcher("/get_news.ftl").forward(req, resp);
            return;
        }

        if("delete".equals(req.getParameter("action"))){
            int id = Integer.parseInt(req.getParameter("id"));

            feedItemDao.deleteFeedItem(id);

            return;
        }

        getServletConfig().getServletContext().getRequestDispatcher("/feed.ftl").forward(req, resp);
    }
}
