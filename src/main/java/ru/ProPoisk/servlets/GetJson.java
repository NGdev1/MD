package ru.ProPoisk.servlets;

import org.codehaus.jackson.map.ObjectMapper;
import ru.ProPoisk.DAO.SquadsDao;
import ru.ProPoisk.DAO.SquadsDaoImpl;
import ru.ProPoisk.DAO.UserDao;
import ru.ProPoisk.DAO.UserDaoImpl;
import ru.ProPoisk.models.Squad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Михаил on 14.12.2016.
 */
@WebServlet("/getJson")
public class GetJson extends HttpServlet {
    UserDao userDao;
    SquadsDao squadsDao;

    @Override
    public void init() throws ServletException {
        userDao = UserDaoImpl.getInstance();
        squadsDao = SquadsDaoImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");

        if("get_squads".equals(action)){
            String query = req.getParameter("query");

            try {
                List<Squad> result = squadsDao.getListBySearch(query);
                PrintWriter pw = resp.getWriter();
                pw.write(new ObjectMapper().writeValueAsString(result));
            } catch (SQLException e) {
                System.out.println("error finding squad " + e.getMessage());
                return;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
