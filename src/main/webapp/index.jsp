<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<%--<form action="ControllerServlet" method="post" >--%>
<%--  <input type="hidden" name="action" value="xxx">--%>
<%--  <input type="submit" value="Call xxx"/>--%>

<%--</form>--%>

<%--<hr/>--%>
<%--<form action="ControllerServlet" method="post">--%>
<%--  <input type="hidden" name="action" value="yyy">--%>
<%--  <input type="submit" value="Call yyy"/>--%>
<%--</form>--%>
<h1>Login</h1>
<form action="ControllerServlet" method="post">
    <label for="name">Username:</label>
    <input type="text" id="name" width=100 style="margin-left: 7px">
    <br>
    <label for="password">Password:</label>
    <input type="text" id="password" width=100 style="margin-left: 10px; margin-bottom: 10px">
    <br>
    <input type="submit" value="Login" style="margin-left: 80px">
    <input type="submit" value="Clear" >
    <br>
</form>
</body>
</html>