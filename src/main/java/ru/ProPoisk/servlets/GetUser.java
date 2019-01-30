package ru.ProPoisk.servlets;

import ru.ProPoisk.DAO.UserDao;
import ru.ProPoisk.DAO.UserDaoImpl;
import ru.ProPoisk.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**

 */

@WebServlet("/user/*")

public class GetUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            int id = Integer.valueOf(req.getPathInfo().substring(1));

            User user = UserDaoImpl.getInstance().getUser(id);
            req.setAttribute("userInfo", user);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        getServletConfig().getServletContext().getRequestDispatcher("/user_info/show_user.ftl").forward(req, resp);
    }
}
