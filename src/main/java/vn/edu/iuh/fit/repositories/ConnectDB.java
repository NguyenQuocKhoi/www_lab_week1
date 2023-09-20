package vn.edu.iuh.fit.repositories;

import java.sql.* ;
import java.sql.DriverManager;

public class ConnectDB {

  public static Connection conn = null;

  public static Connection getConnection() {
    try {
      Class.forName("org.mariadb.jdbc.Driver");
      conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/mydb", "root", "sapassword");
    } catch (Exception e) {
      e.printStackTrace();
    }
    return conn;
  }
}
