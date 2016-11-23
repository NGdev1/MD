package ru.ProPoisk.servlets;

import ru.ProPoisk.DAO.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by apple on 23.09.16.
 */

@WebServlet("/login")

public class Login extends HttpServlet {

    UserDao dao;
    UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();

        dao = UserDaoImpl.getInstance();
        userService = new UserServiceImpl(dao);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if(session.getAttribute("user") != null){
            response.sendRedirect("/");
            return;
        }

        getServletConfig().getServletContext().getRequestDispatcher("/unregistered/login.ftl").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String username = req.getParameter("name");
        String password = req.getParameter("password");

        if (userService.isRegistered(username))
            if (dao.getUser(username).confirmPassword(password)) {
                req.setAttribute("name", "Hey, " + username);
                req.getSession().setAttribute("user", dao.getUser(username));
            } else {
                req.setAttribute("error", "Не верный пароль");
                getServletConfig().getServletContext().getRequestDispatcher("/unregistered/login.ftl").forward(req, resp);
                return;
            }
        else {
            req.setAttribute("error", "Пользователь не найден");
            getServletConfig().getServletContext().getRequestDispatcher("/unregistered/login.ftl").forward(req, resp);
            return;
        }

        resp.sendRedirect("/");
    }
}