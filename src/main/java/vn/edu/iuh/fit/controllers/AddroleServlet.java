package vn.edu.iuh.fit.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import vn.edu.iuh.fit.entities.Account;
import vn.edu.iuh.fit.entities.GrantAccess;
import vn.edu.iuh.fit.entities.Role;
import vn.edu.iuh.fit.repositories.ConnectDB;
import vn.edu.iuh.fit.repositories.RoleRepository;

@WebServlet("/addrole")
public class AddroleServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String accID = req.getParameter("id");
    String roleID = req.getParameter("roleID");
    boolean isGrant = Boolean.parseBoolean(req.getParameter("isGrant"));
    String note = req.getParameter("note");

    Account account = new Account();
    account.setAccountId(accID);
    Role role = new Role();
    role.setRoleId(roleID);
    GrantAccess grantAccess = new GrantAccess(account, role, isGrant, note);

    RoleRepository roleRepository = new RoleRepository(ConnectDB.getConnection());

    boolean addRole = roleRepository.addRole(grantAccess);
    HttpSession session  = req.getSession();

    if(addRole){
      session.setAttribute("success", "Add Role Complete");
      resp.sendRedirect("addRole.jsp");
    }
    else {
      session.setAttribute("error", "Failed");
      resp.sendRedirect("addRole.jsp");
    }

  }
}
