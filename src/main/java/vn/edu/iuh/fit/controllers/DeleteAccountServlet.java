package vn.edu.iuh.fit.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import vn.edu.iuh.fit.repositories.AccountRepository;
import vn.edu.iuh.fit.repositories.ConnectDB;

@WebServlet("/deleteAcc")
public class DeleteAccountServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String id = req.getParameter("id");
    AccountRepository accountRepository = new AccountRepository(ConnectDB.getConnection());
    boolean deleteAcc = accountRepository.deleteAccount(id);

    HttpSession session = req.getSession();
    if(deleteAcc) {
      session.setAttribute("success3","Delete Complete");
      resp.sendRedirect("index.jsp");
    }else {
      session.setAttribute("errorDelete","Delete failed");
      resp.sendRedirect("index.jsp");
    }
  }
}
