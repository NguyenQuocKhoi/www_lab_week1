<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<form action="ControllerServlet" method="post" >
  <input type="hidden" name="action" value="xxx">
  <input type="submit" value="Call xxx"/>

</form>

<hr/>
<form action="ControllerServlet" method="post">
  <input type="hidden" name="action" value="yyy">
  <input type="submit" value="Call yyy"/>
</form>
</body>
</html>