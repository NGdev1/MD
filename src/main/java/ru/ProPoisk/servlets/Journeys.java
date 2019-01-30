package ru.ProPoisk.servlets;

import ru.ProPoisk.DAO.ExpeditionDao;
import ru.ProPoisk.DAO.ExpeditionDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**

 */
@WebServlet("/expeditions")
public class Journeys extends HttpServlet {

    ExpeditionDao expeditionDao;

    @Override
    public void init() throws ServletException {
        expeditionDao = ExpeditionDaoImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        try {
            req.setAttribute("expeditions", expeditionDao.getAll());
        } catch (SQLException e) {
            System.out.println("Error getting expeditions: " + e.getMessage());
        }

        getServletConfig().getServletContext().getRequestDispatcher("/expeditions.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
