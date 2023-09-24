package vn.edu.iuh.fit.repositories;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import vn.edu.iuh.fit.entities.Account;
import vn.edu.iuh.fit.entities.GrantAccess;
import vn.edu.iuh.fit.entities.Role;

public class RoleRepository {

  private Connection connection;

  public RoleRepository(Connection connection) {
    this.connection = connection;
  }

  public boolean addRole(GrantAccess grantAccess) {
    int n = 0;
    try {
      String sql = "INSERT INTO grant_access VALUES (?, ?, ?, ?)";
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, grantAccess.getRole().getRoleId());
      preparedStatement.setString(2, grantAccess.getAccount().getAccountId());
      preparedStatement.setBoolean(3, grantAccess.isGrant());
      preparedStatement.setString(4, grantAccess.getNote());
      n = preparedStatement.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return n > 0;
  }

  public String getRoleByEmail(String email) {
    String roleName = "";
    try {
      String sql = "SELECT grant_access.role_id as roleName\n"
          + "FROM     account INNER JOIN\n"
          + "                  grant_access ON account.account_id = grant_access.account_id INNER JOIN\n"
          + "                  role ON grant_access.role_id = role.role_id\n"
          + "WHERE account.email = ?";

      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, email);
      ResultSet rs = preparedStatement.executeQuery();
      if (rs.next()) {
        roleName = rs.getString("roleName");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return roleName;
  }


  public GrantAccess getGrantBRoleId(String id) {
    GrantAccess grantAccess = null;
    String sql =
        "SELECT role.role_id, account.account_id, grant_access.is_grant, grant_access.note\n"
            + "FROM     account INNER JOIN\n"
            + "                  grant_access ON account.account_id = grant_access.account_id INNER JOIN\n"
            + "                  role ON grant_access.role_id = role.role_id\n"
            + "WHERE account.account_id = ?";

    try {
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, id);
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        grantAccess = new GrantAccess();
        Role role = new Role();
        role.setRoleId(rs.getString(1));
        grantAccess.setRole(role);
        Account account = new Account();
        account.setAccountId(rs.getString(2));
        grantAccess.setAccount(account);

        grantAccess.setGrant(rs.getBoolean(3));
        grantAccess.setNote(rs.getString(4));

      }
    } catch (Exception e) {

      e.printStackTrace();
    }
    return grantAccess;
  }

  public List<Account> findRole(String id) {
    List<Account> accounts = new ArrayList<Account>();
    String sql =
        "SELECT account.account_id, account.full_name, account.password, account.email, account.phone, account.status\n"
            + "FROM     account INNER JOIN\n"
            + "                  grant_access ON account.account_id = grant_access.account_id INNER JOIN\n"
            + "                  role ON grant_access.role_id = role.role_id\n"
            + "WHERE role.role_id = ?\n";
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, id);
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        String accid = rs.getString("account_id");
        String fullname = rs.getString("full_name");
        String email = rs.getString("email");
        String phone = rs.getString("phone");
        int status = Integer.parseInt(rs.getString("status"));
//        String roleName = rs.getString("role_name");
        Account account = new Account(accid, fullname, email, phone, status);
        accounts.add(account);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return accounts;
  }
}
