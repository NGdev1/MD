package ru.ProPoisk.servlets;

import org.codehaus.jackson.map.ObjectMapper;
import ru.ProPoisk.DAO.User;
import ru.ProPoisk.DAO.UserDao;
import ru.ProPoisk.DAO.UserDaoImpl;
import ru.ProPoisk.utils.FormDataCheck;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.TreeMap;

/**
 * Created by apple on 23.09.16.
 */

@WebServlet("/register")

public class Register extends HttpServlet {

    UserDao dao;

    @Override
    public void init() throws ServletException {
        dao = UserDaoImpl.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        if (session.getAttribute("user") != null) {
            resp.sendRedirect("/");
            return;
        }

        req.getRequestDispatcher("/unregistered/register.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        String username = req.getParameter("name");
        String image = req.getParameter("image");
        String password = req.getParameter("password");
        String password2 = req.getParameter("password2");
        String phone = req.getParameter("phone");
        String DOB = req.getParameter("DOB");
        String city = req.getParameter("city");
        String sex = req.getParameter("sex");
        String otryad = req.getParameter("otryad");
        String email = req.getParameter("email");
        String surname = req.getParameter("surname");
        String patronymic = req.getParameter("patronymic");
        String dolshnost = req.getParameter("dolshnost");

        TreeMap message = FormDataCheck.checkAllFieldsAndGetErrorMessageIfFieldsAreInvalid(username, phone, DOB, password, password2, sex, city);

        PrintWriter pw = resp.getWriter();

        if (message.isEmpty()) { //No errors
            boolean isMale = sex.equals("male");
            User user = new User(username, password, isMale, phone, DOB, city, image, otryad, email, surname, patronymic, dolshnost);
            try {
                dao.saveUser(user);
            } catch (SQLException e) {
                pw.write("SQL error!");
                e.printStackTrace();
                pw.close();
                return;
            }

            HttpSession session = req.getSession();
            session.setAttribute("user", user);

            pw.write("success");
        } else {
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(message);

            pw.write(jsonString);
        }
        pw.close();
    }
}
