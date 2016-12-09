package ru.ProPoisk.servlets;

import ru.ProPoisk.DAO.User;
import ru.ProPoisk.DAO.UserDao;
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

@WebServlet("/settings")

public class Settings extends HttpServlet {

    UserDao dao;

    @Override
    public void init() throws ServletException {
        dao = UserDaoImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        User user = (User) session.getAttribute("user");
        req.setAttribute("user", user);

        getServletConfig().getServletContext().getRequestDispatcher("/settings.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String username = req.getParameter("login");
        String surname = req.getParameter("surname");
        String patronymic = req.getParameter("patronymic");
        String phone = req.getParameter("tel");
        String email = req.getParameter("mail");
        String dolshnost = req.getParameter("dolshnost");

        User user = (User) session.getAttribute("user");

        user.setName(username);
        user.setSurname(surname);
        user.setPatronymic(patronymic);
        user.setPhoneNumber(phone);
        user.setEmail(email);
        user.setDolshnost(dolshnost);

        try {
            dao.changeUser(user);
        } catch (SQLException e) {
            System.out.println("Changing profile error:" + e.getMessage());
        }

        session.setAttribute("user", user);

        resp.sendRedirect("/settings");
    }
}
