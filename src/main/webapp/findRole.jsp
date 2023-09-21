<%@ page import="vn.edu.iuh.fit.repositories.AccountRepository" %>
<%@ page import="vn.edu.iuh.fit.repositories.ConnectDB" %>
<%@ page import="vn.edu.iuh.fit.entities.Account" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.repositories.RoleRepository" %><%--
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
    <title>Tìm kiếm theo role</title>

</head>
<body>
<%@include file="./menu.jsp" %>
<div class="col-xs-12" style="height: 1090px; width: 960px; margin: auto;">
    <h4 style="text-align:center;">Danh sách các Account</h4>
    <table class="table table-striped" role="table">
        <form action="findAcc" method="post">
            <tr>
                <th>Account ID</th>
                <th>Full Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Status</th>
                <th>
                    <select name="id" >
                        <option>admin</option>
                        <option>user</option>
                    </select>
                </th>
                <th></th>

            </tr>
            <tbody>
<%--            <% String id = request.getParameter("id");--%>
<%--                RoleRepository roleRepository = new RoleRepository(ConnectDB.getConnection());--%>
<%--                List<Account> list = roleRepository.findRole(id);--%>
<%--                for(Account account: list){--%>
<%--            %>--%>
<%--            <tr>--%>
<%--                <td><%=account.getAccountId() %>--%>
<%--                </td>--%>
<%--                <td><%= account.getFullName() %>--%>
<%--                </td>--%>
<%--                <td><%= account.getEmail() %>--%>
<%--                </td>--%>
<%--                <td><%= account.getPhone() %>--%>
<%--                </td>--%>
<%--                <td><%= account.getStatus()%>--%>
<%--                </td>--%>

<%--            </tr>--%>

<%--            <%--%>
<%--                }--%>
<%--                %>--%>
            </tbody>


        </form>
    </table>

</div>
</body>
</html>
