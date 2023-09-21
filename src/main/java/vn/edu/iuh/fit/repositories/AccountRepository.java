package vn.edu.iuh.fit.repositories;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;
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

  public List<Object[]> getAccount() {
    List<Object[]> list = new ArrayList<Object[]>();
    String sql =
        "SELECT account.account_id, account.full_name, account.email, account.phone, account.status, role.role_name\n"
            + "FROM     account INNER JOIN\n"
            + "                  grant_access ON account.account_id = grant_access.account_id INNER JOIN\n"
            + "                  role ON grant_access.role_id = role.role_id";
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        String id = rs.getString("account_id");
        String fullname = rs.getString("full_name");
        String email = rs.getString("email");
        String phone = rs.getString("phone");
        int status = Integer.parseInt(rs.getString("status"));
        String roleName = rs.getString("role_name");
        Object[] o = {id, fullname, email, phone, status, roleName};
        list.add(o);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }

  public List<Account> getAccount1() {
    List<Account> accounts = new ArrayList<Account>();
    String sql =
        "                  SELECT account.full_name, account.email, account.phone, role.role_id\n"
            + "FROM     account INNER JOIN\n"
            + "                  grant_access ON account.account_id = grant_access.account_id INNER JOIN\n"
            + "                  role ON grant_access.role_id = role.role_id\n"
            + "where role.role_id like 'user'";
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        String fullName = resultSet.getString("full_name");
        String email = resultSet.getString("email");
        String phone = resultSet.getString("phone");
        Account account = new Account(fullName, email, phone);
        accounts.add(account);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return accounts;
  }

  public boolean updateAccount(Account account) {
    int n = 0;
    String sql =
        "update account set   full_name = ?, password = ?, email = ?, phone = ?, status = ?\n"
            + "where account_id = ?";
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, account.getFullName());
      preparedStatement.setString(2, account.getPassword());
      preparedStatement.setString(3, account.getEmail());
      preparedStatement.setString(4, account.getPhone());
      preparedStatement.setInt(5, account.getStatus());
      preparedStatement.setString(6, account.getAccountId());
      n = preparedStatement.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return n > 0;
  }

  public boolean deleteAccount(String id) {
    int n = 0;
    String sql = "delete from account where account_id =?";
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, id);
      n = preparedStatement.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return n > 0;
  }

  public Account getAccountByID(String id) {
    Account account = null;
    try {
      String sql = "select account_id from account where account_id = ?";
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1, id);
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        account = new Account();
        account.setAccountId(rs.getString(1));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return account;
  }
}
