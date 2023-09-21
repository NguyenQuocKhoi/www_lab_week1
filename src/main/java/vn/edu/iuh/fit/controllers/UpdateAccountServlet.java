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

@WebServlet("/updateAcc")
public class UpdateAccountServlet extends HttpServlet {

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

    boolean updateAcc = accountRepository.updateAccount(account);
    HttpSession session = req.getSession();
    if(updateAcc){
      session.setAttribute("success2", "Update account complete");
      resp.sendRedirect("index.jsp");
    }else {
      session.setAttribute("error2", "Update failed");
      resp.sendRedirect("index.jsp");
    }
  }
}
