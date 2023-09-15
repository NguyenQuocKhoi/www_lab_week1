package vn.edu.iuh.fit.entities;

import java.time.LocalDate;

public class Log {
  private int id;
  private Account account;
  private LocalDate loginTime;
  private LocalDate logoutTime;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  public LocalDate getLoginTime() {
    return loginTime;
  }

  public void setLoginTime(LocalDate loginTime) {
    this.loginTime = loginTime;
  }

  public LocalDate getLogoutTime() {
    return logoutTime;
  }

  public void setLogoutTime(LocalDate logoutTime) {
    this.logoutTime = logoutTime;
  }

  public Log() {
  }

  public Log(int id, Account account, LocalDate loginTime, LocalDate logoutTime) {
    this.id = id;
    this.account = account;
    this.loginTime = loginTime;
    this.logoutTime = logoutTime;
  }

  @Override
  public String toString() {
    return "Log{" +
        "id=" + id +
        ", account=" + account +
        ", loginTime=" + loginTime +
        ", logoutTime=" + logoutTime +
        '}';
  }
}
