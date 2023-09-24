<%@ page import="vn.edu.iuh.fit.repositories.AccountRepository" %>
<%@ page import="vn.edu.iuh.fit.repositories.ConnectDB" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.entities.Account" %><%--
  Created by IntelliJ IDEA.
  User: quockhoi
  Date: 21/09/2023
  Time: 8:32 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="css.jsp"%>
</head>
<body>
<%--<%@include file="./menu.jsp"%>--%><div class="container">
    <%--        <div class="col-xs-12">--%>
    <%--            &lt;%&ndash;            <img src="../IMG/paner.jpg" alt="" width="100%">&ndash;%&gt;--%>
    <%--        </div>--%>
    <div class="col-xs-12">
        <nav class="navbar navbar-expand-sm">
            <ul class="navbar nav">

                <li class="navbar-item"><a href="./dashboard.jsp" class="navbar-link"
                                           style="margin-right: 20px; color: black; text-decoration: none"
                                           id="btn1">Home</a>
                </li>
                <li class="navbar-item"><a href="./index.jsp" class="navbar-link" id="btn3"
                                           style="margin-right: 20px; color: black; text-decoration: none">Log
                    out</a>
                </li>
            </ul>
        </nav>
    </div>
</div>
<div class="col-xs-12" style="height: 1090px; width: 960px; margin: auto;" >
    <h4 style="text-align:center;">Danh sách các Account</h4>
    <table class="table table-striped" role="table">
        <form action="" method="post">
            <tr>
                <th>Full Name</th>
                <th>Email</th>
                <th>Phone</th>
            </tr>
            <tbody>
            <% AccountRepository accountRepository = new AccountRepository(
                    ConnectDB.getConnection());
                List<Account> list = accountRepository.getAccount1();
               for(Account a : list){
            %>
            <tr>
                <td><%=a.getFullName()%>
                </td>
                <td><%=a.getEmail()%>
                </td>
                <td><%=a.getPhone()%>
                </td>
            </tr>
            <%
                }
            %>
            </tbody>
        </form>
    </table>


</div>
</body>
</html>
