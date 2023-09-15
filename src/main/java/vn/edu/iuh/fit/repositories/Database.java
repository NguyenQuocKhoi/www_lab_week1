package vn.edu.iuh.fit.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import vn.edu.iuh.fit.entities.Role;

public class Database {

  private Connection connection = null;

  public Database() {
    String url = "jdbc:mariadb://localhost:3306/mydb";
    try {
      connection = DriverManager.getConnection(url, "root", "sapassword");
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
  public void  createRole(Role role){
    try {
      PreparedStatement statement = connection.prepareStatement(" INSERT INTO role (?, ?, ?, ?)");
      statement.setString(1,role.getRoleId());
      statement.setString(2, role.getRoleName());
      statement.setString(3, role.getDescription());
      statement.setInt(4, role.getStatus());
      int rowsInserted = statement.executeUpdate();
    }catch (SQLException e){
      throw  new RuntimeException(e);
    }
  }


}
