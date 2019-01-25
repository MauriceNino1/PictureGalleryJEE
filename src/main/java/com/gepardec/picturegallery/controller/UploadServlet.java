package com.gepardec.picturegallery.controller;

import com.gepardec.picturegallery.model.ImagePost;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.Properties;

@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    @java.lang.Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log(request.getRemoteAddr()+" has made a POST request");

        String jdbc_properties = getInitParameter("jdbc_properties");
        ServletContext application = getServletContext();
        InputStream in = application.getResourceAsStream(jdbc_properties);
        Properties properties = new Properties();
        properties.load(in);

        String imageTitle = request.getParameter("title");
        Part image = request.getPart("image");

        File directory = new File("tmp/imgs");
        if (! directory.exists()){
            log("Dir doesnt exist");
            directory.mkdirs();
        }

        File file = new File("tmp/imgs/"+image.getSubmittedFileName());
        FileOutputStream os = new FileOutputStream(file);

        byte[] b = new byte[1024];
        int i=0;
        InputStream is = image.getInputStream();
        while((i=is.read()) != -1){
            os.write(b, 0, 1);
        }

        Cookie cookie1 = new Cookie("latestPostTitle", imageTitle);
        Cookie cookie2 = new Cookie("latestPostImageName", image.getSubmittedFileName());
        Cookie cookie3 = new Cookie("latestPostImagePath", "/imgs/"+image.getSubmittedFileName());
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        response.addCookie(cookie3);


        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");


        response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
        response.setHeader("Location", "latestPost");


        /*out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Ihr Driver: " + properties.getProperty("driver") + "</h1>");
        out.println("<h1>: " + properties.getProperty("url") + "</h1>");
        out.println("<h1>: " + properties.getProperty("username") + "</h1>");
        out.println("<h1>: " + properties.getProperty("password") + "</h1>");
        out.println("<h1>Ihr Titel: " + imageTitle + "</h1>");
        out.println("<h1>Ihr Bild: </h1><p>" + image + "</p>");
        out.println("</body>");
        out.println("</html>");*/
    }


    @java.lang.Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log(request.getRemoteAddr()+" has made a GET request");

        PrintWriter out = response.getWriter();

        response.setContentType("text/html;charset=UTF-8");
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>" + "NOT SUPPORTED" + "</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
