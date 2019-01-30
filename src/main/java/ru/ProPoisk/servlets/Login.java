package ru.ProPoisk.servlets;

import ru.ProPoisk.DAO.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**

 */

@WebServlet("/login")

public class Login extends HttpServlet {

    public static UserDao dao = UserDaoImpl.getInstance();
    public static UserService userService = new UserServiceImpl(dao);

    public enum UserLoginState {
        IncorrectPassword,
        IncorrectName,
        Success
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (session.getAttribute("user") != null) {
            response.sendRedirect("/");
            return;
        }

        getServletConfig().getServletContext().getRequestDispatcher("/unregistered/login.ftl").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        if (login(req, resp)) {
            resp.sendRedirect("/");
        } else {
            req.getRequestDispatcher("/unregistered/login.ftl").forward(req, resp);
        }
    }

    public static boolean login(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("name");
        String password = req.getParameter("password");
//        String save = req.getParameter("save");

        if (username == null || password == null) {
            return false;
        }

        UserLoginState state = login(username, password, req.getSession());

        if (state == UserLoginState.Success) {
            req.setAttribute("name", "Hey, " + username);

            try {
                addCookie(resp, username, password);
            } catch (UnsupportedEncodingException e) {
                System.out.println("Не получилось создать куки");
            }

            return true;
        } else if (state == UserLoginState.IncorrectPassword) {
            req.setAttribute("error", "Не верный пароль");

            return false;
        } else {
            req.setAttribute("error", "Пользователь не найден");

            return false;
        }
    }

    public static UserLoginState login(String name, String password, HttpSession session) {
        if (userService.isRegistered(name))
            if (dao.getUser(name).confirmPassword(password)) {
                session.setAttribute("user", dao.getUser(name));
                return UserLoginState.Success;
            } else {
                return UserLoginState.IncorrectPassword;
            }
        else {
            return UserLoginState.IncorrectName;
        }
    }

    public static void addCookie(HttpServletResponse response, String key, String value) throws UnsupportedEncodingException {
        // Create cookies for first and last names.
        Cookie name = new Cookie("name",
                URLEncoder.encode(key, "UTF-8"));
        Cookie pass = new Cookie("pass",
                URLEncoder.encode(value, "UTF-8"));

        // Set expiry date after 24 Hrs for both the cookies.
        name.setMaxAge(60 * 60 * 24 * 25);
        pass.setMaxAge(60 * 60 * 24 * 25);

        // Add both the cookies in the response header.
        response.addCookie(name);
        response.addCookie(pass);
    }
}