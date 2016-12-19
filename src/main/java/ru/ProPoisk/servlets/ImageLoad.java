package ru.ProPoisk.servlets;

import org.apache.commons.fileupload.FileUploadException;
import ru.ProPoisk.DAO.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import ru.ProPoisk.models.User;

@WebServlet("/image_load/*")
public class ImageLoad extends HttpServlet {

    UserDaoImpl userDao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getRequestURI().substring(12);
        int id = new Integer(userId).intValue();

        userDao = UserDaoImpl.getInstance();

        String imageName = null;
        File uploadedFile = null;

        DiskFileItemFactory factory = new DiskFileItemFactory();

        factory.setSizeThreshold(1024*1024);

        File tempDir = (File) getServletContext().getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(tempDir);

        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setSizeMax(1024 * 1024 * 10);

        try {
            List items = upload.parseRequest(req);
            Iterator iter = items.iterator();

            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();

                if (!item.isFormField()) {
                    imageName = item.getName();

                    String path = getServletContext().getRealPath("/upload/" + imageName);
                    uploadedFile = new File(path);

                    uploadedFile.createNewFile();

                    item.write(uploadedFile);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        userDao.setUserImage(imageName, id);

        User user = userDao.getUser(id);

        req.getSession().setAttribute("user", user);

        resp.sendRedirect("/settings");
    }
}
