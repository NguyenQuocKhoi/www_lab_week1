<%@ page import="vn.edu.iuh.fit.repositories.AccountRepository" %>
<%@ page import="vn.edu.iuh.fit.repositories.ConnectDB" %>
<%@ page import="vn.edu.iuh.fit.entities.Account" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: quockhoi
  Date: 15/09/2023
  Time: 1:07 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="./css.jsp" %>
<html>
<head>
    <title>dashboard</title>

</head>
<body>
<%@include file="./menu.jsp"%>
<div class="col-xs-12" style="height: 1090px; width: 960px; margin: auto;" >
    <h4 style="text-align:center;">Danh sách các Account</h4>
    <table class="table table-striped" role="table">
        <form action="" method="post">
            <tr>
                <th>Account ID</th>
                <th>Full Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Status</th>
                <th>Role</th>
                <th></th>
                <th></th>
                <th></th>
            </tr>
            <tbody>
            <% AccountRepository accountRepository = new AccountRepository(
                    ConnectDB.getConnection());
                List<Object[]> list = accountRepository.getAccount();
                for (int i = 0; i < list.size(); i++) {
                  String status = String.valueOf(Integer.parseInt(list.get(i)[4].toString()));
                  if(status.equalsIgnoreCase("1")){
                    status = "Active";
                  }
                  if(status.equalsIgnoreCase("0")){
                      status = "Deactive";
                  }
                  if(status.equalsIgnoreCase("-1")){
                    status = "Xoa";
                  }
            %>
            <tr>
                <td><%= list.get(i)[0].toString() %>
                </td>
                <td><%= list.get(i)[1].toString() %>
                </td>
                <td><%= list.get(i)[2].toString() %>
                </td>
                <td><%= list.get(i)[3].toString() %>
                </td>
                <td><%= status %>
                </td>
                <td><%= list.get(i)[5].toString() %>
                </td>

                <td><input type="button" name="edit" id="edit" value="Edit" /></td>
                <td><input type="button" name="delete" id="delete" value="Delete"/></td>
                <td><a href="addRole.jsp"><input type="button" name="addrole" id="addrole" value="Add Role"/> </a>
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
