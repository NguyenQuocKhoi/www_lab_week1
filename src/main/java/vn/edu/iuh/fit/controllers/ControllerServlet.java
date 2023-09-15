package vn.edu.iuh.fit.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/ControllerServlet", "/control"})
public class ControllerServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String action = request.getParameter("action");
    PrintWriter out = response.getWriter();
    if (action.equalsIgnoreCase("xxx")) {
      out.println("You call action xxx");
    } else if (action.equalsIgnoreCase("yyy")) {
      //out.println("You call action yyy");
      response.sendRedirect("dashboard.jsp");
    }

  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse resp)
      throws ServletException, IOException {
    String action = request.getParameter("action");
    if (action.equalsIgnoreCase("xxx")) {

    } else if (action.equalsIgnoreCase("yyy")) {

    }
  }

}
