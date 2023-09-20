package vn.edu.iuh.fit.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JList;
import vn.edu.iuh.fit.entities.Account;
import vn.edu.iuh.fit.repositories.AccountRepository;

@WebServlet(urlPatterns = {"/ControllerServlet", "/control"})
public class ControllerServlet extends HttpServlet {

  private AccountRepository accountRepository;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
//    String action = request.getParameter("action");
//    PrintWriter out = response.getWriter();
//    if (action.equalsIgnoreCase("xxx")) {
//      out.println("You call action xxx");
//    } else if (action.equalsIgnoreCase("yyy")) {
//      //out.println("You call action yyy");
//      response.sendRedirect("dashboard.jsp");
//    }
//    try {
//      PrintWriter out = response.getWriter();
//      HttpSession session = request.getSession(true);
//      accountRepository = new AccountRepository(session);
//      String accId = request.getParameter("account_id");
//      String passWord = request.getParameter("password");
//      boolean rs = accountRepository.login(accId, passWord);
//      if (!rs) {
//        response.getWriter().println("sai mat khau hoac tai khoan");
//      } else {
//         session.getAttribute("ds");
//
//          response.sendRedirect("dashboard.jsp");
//      }
//      ArrayList<Account> accs = (ArrayList<Account>) session.getAttribute("ds");
//    } catch (Exception e) {
//      throw new RuntimeException(e);
//    }
//  }
//
////  @Override
////  protected void doGet(HttpServletRequest request, HttpServletResponse resp)
////      throws ServletException, IOException {
////    String action = request.getParameter("action");
////    if (action.equalsIgnoreCase("xxx")) {
////
////    } else if (action.equalsIgnoreCase("yyy")) {
////
////    }
////  }
  }
}
