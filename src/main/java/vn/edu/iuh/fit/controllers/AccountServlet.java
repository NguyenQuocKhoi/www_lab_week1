package vn.edu.iuh.fit.controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import vn.edu.iuh.fit.entities.Account;
import vn.edu.iuh.fit.entities.GrantAccess;
import vn.edu.iuh.fit.entities.Role;
import vn.edu.iuh.fit.repositories.AccountRepository;
import vn.edu.iuh.fit.repositories.ConnectDB;
import vn.edu.iuh.fit.repositories.RoleRepository;

@WebServlet("/login")
public class AccountServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    RoleRepository roleRepository = new RoleRepository(ConnectDB.getConnection());
    String roleName = roleRepository.getRole();
  String userName = req.getParameter("username");
  String passWord = req.getParameter("password");
    AccountRepository accountRepository = new AccountRepository(ConnectDB.getConnection());
    Account account  = accountRepository.login(userName, passWord);
    HttpSession session = req.getSession();
    RequestDispatcher requestDispatcher = null;
    if(userName.equals("")|| passWord.equals("")){
      req.setAttribute("status", "Invalid Email or Password");
      requestDispatcher = req.getRequestDispatcher("index.jsp");
      requestDispatcher.forward(req, resp);
    }
    else if (account!=null && roleName.equalsIgnoreCase("user")){
      session.setAttribute("fullName", account.getFullName());
      session.setAttribute("phone", account.getPhone());
      requestDispatcher = req.getRequestDispatcher("dashboard1.jsp");
    }
    else if(account!=null && roleName.equalsIgnoreCase("admin")){
      session.setAttribute("account_id", account.getAccountId());
      session.setAttribute("fullName", account.getFullName());
      session.setAttribute("phone", account.getPhone());
      session.setAttribute("status", account.getStatus());
      requestDispatcher = req.getRequestDispatcher("dashboard.jsp");
    }

    else {
      req.setAttribute("status2", "Wrong Email or Password");
      requestDispatcher = req.getRequestDispatcher("index.jsp");
    }
    requestDispatcher.forward(req, resp);
  }
}
