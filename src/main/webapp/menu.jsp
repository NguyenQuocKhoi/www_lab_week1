<%--
  Created by IntelliJ IDEA.
  User: quockhoi
  Date: 21/09/2023
  Time: 6:00 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="./css.jsp" %>
    <div class="container">
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
                    <li class="navbar-item"><a href="./addAccount.jsp" class="navbar-link" id="btn2"
                                               style="margin-right: 20px; color: black; text-decoration: none">Register
                        an account</a>
                    </li>
                    <li class="navbar-item"><a href="./addRole.jsp" class="navbar-link" id="btn4"
                                               style="margin-right: 20px; color: black; text-decoration: none">
                        Add role</a>
                    </li>
                    <li class="navbar-item"><a href="./findRole.jsp" class="navbar-link" id="btn5"
                                               style="margin-right: 20px; color: black; text-decoration: none">
                        Search by role</a>
                    </li>
                    <li class="navbar-item"><a href="./index.jsp" class="navbar-link" id="btn3"
                                               style="margin-right: 20px; color: black; text-decoration: none">Log
                        out</a>
                    </li>


<%--                    <%--%>
<%--                        String id = request.getParameter("id");--%>
<%--                        AccountRepository accountRepository = new AccountRepository(--%>
<%--                                ConnectDB.getConnection());--%>
<%--                        Account account = accountRepository.getAccount(id);--%>
<%--                    %>--%>

<%--                    <li class="navbar-item"><%=account.getAccountId()%>--%>
<%--                    </li>--%>
                </ul>
            </nav>
        </div>
    </div>
</head>
<body>

</body>
</html>
