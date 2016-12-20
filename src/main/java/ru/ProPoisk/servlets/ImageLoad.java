package ru.ProPoisk.servlets;

import ru.ProPoisk.DAO.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import ru.ProPoisk.models.User;

@WebServlet("/image_load/*")
public class ImageLoad extends HttpServlet {

    UserDaoImpl userDao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String userId = req.getRequestURI().substring(12);
            int id = new Integer(userId).intValue();

            userDao = UserDaoImpl.getInstance();

            String path = getServletContext().getRealPath("/upload/" + userId);

            File file = new File(path);
            if(!file.exists()) file.createNewFile();
            FileOutputStream outputStream = new FileOutputStream(file);

            ServletInputStream inputStream = req.getInputStream();
            while (!inputStream.isFinished()) {
                outputStream.write(inputStream.read());
            }

            outputStream.close();

            userDao.setUserImage(userId, id);

            User user = userDao.getUser(id);

            req.getSession().setAttribute("user", user);

            resp.sendRedirect("/settings");
        } catch (Exception e) {
            System.out.println("Error loading image: " + e.getMessage());
        }
    }
}
