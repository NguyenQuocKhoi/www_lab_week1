package vn.edu.iuh.fit.repositories;

import java.sql.*;
import vn.edu.iuh.fit.entities.GrantAccess;

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

  public String getRole() {
    String roleName = "";
    try {
      String sql = "SELECT role.role_id as roleName\n"
          + "FROM     account INNER JOIN\n"
          + "                  grant_access ON account.account_id = grant_access.account_id INNER JOIN\n"
          + "                  role ON grant_access.role_id = role.role_id";
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      ResultSet rs = preparedStatement.executeQuery();
      if (rs.next()) {
        roleName = rs.getString("roleName");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return roleName;
  }
}
