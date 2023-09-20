package vn.edu.iuh.fit.repositories;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.swing.JList;
import org.checkerframework.checker.units.qual.A;
import vn.edu.iuh.fit.entities.Account;
import vn.edu.iuh.fit.entities.Role;

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

  public Account getAccount2(String id) {
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
    List<Object[]> listOB = new ArrayList<Object[]>();
    try {
      String sql =
          "SELECT account.account_id, account.full_name, account.email, account.phone, account.status, role.role_name\n"
              + "FROM     account INNER JOIN\n"
              + "                  grant_access ON account.account_id = grant_access.account_id INNER JOIN\n"
              + "                  role ON grant_access.role_id = role.role_id";

      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        String id = rs.getString("account_id");
        String fullName = rs.getString("full_name");
        String email = rs.getString("email");
        String phone = rs.getString("phone");
        int status = rs.getInt("status");
//        Role role = new Role();
        String roleName = rs.getString("role_name");
        Object[] o = {id, fullName, email, phone, status, roleName};
        listOB.add(o);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return listOB;
  }

  public List<Account> getAccount1() {
    List<Account> list = new ArrayList<Account>();
    try {
      String sql = "     SELECT account.full_name, account.email, account.phone, role.role_id\n"
          + "FROM     account INNER JOIN\n"
          + "                  grant_access ON account.account_id = grant_access.account_id INNER JOIN\n"
          + "                  role ON grant_access.role_id = role.role_id\n"
          + "where role.role_id like 'user'";
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      ResultSet rs = preparedStatement.executeQuery();
      while (rs.next()) {
        String fullName = rs.getString("full_name");
        String email = rs.getString("email");
        String phone = rs.getString("phone");
        Account account = new Account(fullName, email, phone);
        list.add(account);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }
}
