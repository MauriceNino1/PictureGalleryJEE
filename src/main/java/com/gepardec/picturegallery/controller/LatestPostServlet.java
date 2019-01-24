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

@WebServlet("/latestPost")
public class LatestPostServlet extends HttpServlet{


    @java.lang.Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title="", image="";
        for(Cookie c : request.getCookies()){
            if(c.getName().equals("latestPostTitle")) title = c.getValue();
            if(c.getName().equals("latestPostImage")) image = c.getValue();
        }

            PrintWriter out = response.getWriter();

        response.setContentType("text/html;charset=UTF-8");
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Ihr Titel: " + title + "</h1>");
        out.println("<h1>Ihr Bild: </h1><p>" + image + "</p>");
        out.println("</body>");
    }
}
