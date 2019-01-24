package com.gepardec.picturegallery.controller;

import com.gepardec.picturegallery.model.ImagePost;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
    @java.lang.Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log(request.getRemoteAddr()+" has made a POST request");

        String imageTitle = request.getParameter("title");
        String image = request.getParameter("image");


        Cookie cookie1 = new Cookie("latestPostTitle", imageTitle);
        Cookie cookie2 = new Cookie("latestPostImage", image);

        PrintWriter out = response.getWriter();

        response.addCookie(cookie1);
        response.addCookie(cookie2);
        response.setContentType("text/html;charset=UTF-8");
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Ihr Titel: " + imageTitle + "</h1>");
        out.println("<h1>Ihr Bild: </h1><p>" + image + "</p>");
        out.println("</body>");
        out.println("</html>");
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
