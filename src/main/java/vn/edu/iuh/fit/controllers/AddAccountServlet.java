package vn.edu.iuh.fit.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import vn.edu.iuh.fit.entities.Account;
import vn.edu.iuh.fit.repositories.AccountRepository;
import vn.edu.iuh.fit.repositories.ConnectDB;

@WebServlet("/register")
public class AddAccountServlet  extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String id = req.getParameter("id");
    String fullName = req.getParameter("fullName");
    String pass = req.getParameter("pass");
    String email = req.getParameter("email");
    String phone = req.getParameter("phone");
    int status = Integer.parseInt(req.getParameter("statuss"));
    Account account = new Account(id, fullName, pass, email, phone, status);
    AccountRepository accountRepository = new AccountRepository(ConnectDB.getConnection());
    boolean addAccount = accountRepository.addAccount(account);
    HttpSession session = req.getSession();
    if(addAccount) {
      session.setAttribute("success", "\n"
          + "Account added successfully");
      resp.sendRedirect("addAccount.jsp");

    }else {
      session.setAttribute("error", "Failed");
      resp.sendRedirect("addAccount.jsp");
    }
  }
}
