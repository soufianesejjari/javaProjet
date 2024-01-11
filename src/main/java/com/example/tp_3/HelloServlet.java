package com.example.tp_3;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello le World!";
    }
    Etudiant etudiant= new Etudiant();
    // Définissez le nom de l'étudiant

    String s= etudiant.getNom();
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + s + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}