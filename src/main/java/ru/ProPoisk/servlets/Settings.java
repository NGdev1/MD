package ru.ProPoisk.servlets;

import org.codehaus.jackson.map.ObjectMapper;
import ru.ProPoisk.DAO.ExpeditionDao;
import ru.ProPoisk.DAO.ExpeditionDaoImpl;
import ru.ProPoisk.models.Expedition;
import ru.ProPoisk.models.User;
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
import java.util.Arrays;

/**
 * Created by Михаил on 13.11.2016.
 */

@WebServlet("/settings")

public class Settings extends HttpServlet {

    UserDao userDao;
    ExpeditionDao expeditionDao;

    @Override
    public void init() throws ServletException {
        userDao = UserDaoImpl.getInstance();
        expeditionDao = ExpeditionDaoImpl.getInstance();
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

        String action = req.getParameter("action");

        if("change_profile".equals(action)){
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
                userDao.changeUser(user);
            } catch (SQLException e) {
                System.out.println("Changing profile error:" + e.getMessage());
            }

            session.setAttribute("user", user);

            resp.sendRedirect("/settings");
        } else if("add_expedition".equals(action)){
            String name = req.getParameter("name");
            String participantsParameter = req.getParameter("participants");
            String squadsParameter = req.getParameter("squads");
            String place = req.getParameter("place");

            ObjectMapper mapper = new ObjectMapper();
            Integer[] participants = mapper.readValue(participantsParameter, Integer[].class);
            Integer[] squads = mapper.readValue(squadsParameter, Integer[].class);

            Expedition expedition = new Expedition(0, name, false, place);

            try {
                expeditionDao.saveJourney(expedition);

                expedition = expeditionDao.getJourney(expedition.getName());

                expeditionDao.addParticipantsToJourney(Arrays.asList(participants), expedition);
                expeditionDao.addSquadsToJourney(Arrays.asList(squads), expedition);
            } catch (SQLException e) {
                System.out.println("Error saving expedition: " + e.getMessage());
            }

            resp.getWriter().write("success");
        }
    }
}
