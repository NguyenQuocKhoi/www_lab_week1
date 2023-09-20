package vn.edu.iuh.fit.repositories;

import java.sql.*;
import vn.edu.iuh.fit.entities.Account;

public class AccountRepository {

  private Connection connection;

  public AccountRepository(Connection conn) {
    this.connection = conn;
  }

  public boolean addAccount(Account account) {
    int n = 0;
    try {
      String sql = "INSERT INTO account VALUE (?, ?, ?, ?, ?, ?)";
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, account.getAccountId());
      preparedStatement.setString(2, account.getFullName());
      preparedStatement.setString(3, account.getPassword());
      preparedStatement.setString(4, account.getEmail());
      preparedStatement.setString(5, account.getPhone());
      preparedStatement.setInt(6, account.getStatus());
      n = preparedStatement.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return n > 0;
  }

  public Account login(String email, String pass) {
    Account account = null;
    try {
      String sql = "SELECT * FROM account WHERE email = ? AND PASSWORD = ?";
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, email);
      preparedStatement.setString(2, pass);
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        account = new Account();
        account.setAccountId(rs.getString(1));
        account.setFullName(rs.getString(2));
        account.setPassword(rs.getString(3));
        account.setEmail(rs.getString(4));
        account.setPhone(rs.getString(5));
        account.setStatus(rs.getInt(6));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return account;
  }

  public Account getAccount(String id) {
    Account account = null;
    try {
      String sql = "select * from account where account_id = ?";
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, id);
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        account = new Account();
        account.setAccountId(rs.getString(1));
        account.setFullName(rs.getString(2));
        account.setPassword(rs.getString(3));
        account.setEmail(rs.getString(4));
        account.setPhone(rs.getString(5));
        account.setStatus(rs.getInt(6));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return account;
  }

//  public boolean login(String accID, String password) throws Exception {
//    PreparedStatement preparedStatement = connection.prepareStatement(
//        "SELECT * FROM account WHERE account_id = ?  AND PASSWORD = ?");
//    preparedStatement.setString(1, accID);
//    preparedStatement.setString(2, password);
//    ResultSet rs = preparedStatement.executeQuery();
//    if (rs.next()) {
//      GrantAccess grantAccess = new GrantAccess();
//      String role = grantAccess.getRole().getRoleId();
//      if (role.equalsIgnoreCase("admin")) {
//        Statement statement = connection.createStatement();
//        ResultSet rs1 = statement.executeQuery("Select * from account");
//        List<Account> accs = new ArrayList<>();
//        while (rs1.next()) {
//          Account acc = new Account(rs1.getString(1), rs1.getString(2), rs1.getString(3),
//              rs1.getString(4), rs1.getString(5), rs1.getInt(6));
//          accs.add(acc);
//        }
//        httpSession.setAttribute("ds", accs);
//      }
//      return true;
//    }
//    return false;
//  }
//
//  public void closeConnection() throws SQLException {
//    if (connection != null) {
//      connection.close();
//    }
//  }

}
