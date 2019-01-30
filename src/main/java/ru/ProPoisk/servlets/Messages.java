package ru.ProPoisk.servlets;

import ru.ProPoisk.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**

 */

@WebServlet("/im")

public class Messages extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if(session.getAttribute("user") == null){
            req.setAttribute("NoUser", "no");
        }

        if(session.getAttribute("user") == null){
            req.setAttribute("NoUser", "no");
        }
        else {
            User user = (User)session.getAttribute("user");

            req.setAttribute("name", "Hey, " + user.getName());
        }

        getServletConfig().getServletContext().getRequestDispatcher("/messages.ftl").forward(req, resp);
    }
}
