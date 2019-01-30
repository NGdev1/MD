package ru.ProPoisk.servlets;

import ru.ProPoisk.DAO.ExpeditionDao;
import ru.ProPoisk.DAO.ExpeditionDaoImpl;
import ru.ProPoisk.DAO.PointDao;
import ru.ProPoisk.DAO.PointDaoImpl;
import ru.ProPoisk.models.Expedition;
import ru.ProPoisk.models.Point;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**

 */
@WebServlet("/full_map/*")
public class FullMap extends HttpServlet {
    ExpeditionDao expeditionDao = ExpeditionDaoImpl.getInstance();
    PointDao pointDao = PointDaoImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            int idExpedition = Integer.parseInt(req.getPathInfo().substring(1));

            Expedition expedition = expeditionDao.getJourney(idExpedition);
            req.setAttribute("expedition", expedition);
        }catch (Exception e){
            //ignore error
        }

        try {
            List<Point> points = pointDao.getAll();
            req.setAttribute("points", points);
        } catch (SQLException e) {
            System.out.println("Error getting all points: " + e.getMessage());
        }

        req.getServletContext().getRequestDispatcher("/full_map.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        try {
            String action = req.getParameter("action");

            if("add_point".equals(action)){
                int idExpedition = Integer.parseInt(req.getPathInfo().substring(1));

                String name = req.getParameter("name");
                String text = req.getParameter("desc");
                Double longitude = Double.valueOf(req.getParameter("lon"));
                Double latitude = Double.valueOf(req.getParameter("lat"));

                Point point = new Point(
                        -1,
                        idExpedition,
                        longitude,
                        latitude,
                        name,
                        text,
                        "2016-11-02",
                        "no_photo2.png"
                );

                pointDao.savePoint(point);

                resp.sendRedirect(String.valueOf(req.getRequestURL()));
            }

        } catch (Exception e) {
            System.out.println("Error adding point: " + e.getMessage());
        }
    }
}
