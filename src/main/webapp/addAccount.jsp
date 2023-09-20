<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="./css.jsp" %>
</head>
<body>
<%@include file="./menu.jsp"%>
<div class ="container p-4">
    <div class="row" style="margin-top:10px;">
        <div class="content" style="height: 1090px; width: 960px; margin: auto">
            <div class="header">
                <h2 class="text-left" style="text-align: center">THÔNG TIN CÁ NHÂN</h2>
            </div>
            <div class="body" style="margin-top: 10px">
                <form action="register" method="post">


                        <label for="id" class="control-label col-xs-3">Account ID</label>
                        <input type="text" name="id" id="id" class="form-control">


                        <label for="fullName" class="control-label col-xs-3">Full Name</label>
                        <input type="text" name="fullName" id="fullName" class="form-control">


                        <label for="pw" class="control-label col-xs-3">Password</label>
                        <input type="text" name="pass" id="pw" class="form-control">


                        <label for="email" class="control-label col-xs-3">Email</label>
                        <input type="text" name="email" id="email" class="form-control">



                        <label for="SDT" class="control-label col-xs-3">Phone</label>
                        <input type="text" name="phone" id="SDT" class="form-control">


                        <label for="statuss" class="control-label col-xs-3">Status</label>
                        <input type="text" name="statuss" id="statuss" class="form-control">


                    <button class="btn btn-group-justified" name="submit1" id="Save"
                            type="submit"
                            style="color: white; margin-top: 10px; background-color: green; width: 100%;">
                        Add Account
                    </button>

                    <button class="btn btn-group-justified" name="submit1" id="Clear"
                            type="reset"
                            style="color: white; margin-top: 10px; background-color: green; width: 100%;">
                        Clear
                    </button>

                </form>

                <c:if test="${not empty success}">
                    <p class="text-center text-success">${success}</p>
                    <c:remove var="success"/>

                </c:if>

                <c:if test="${not empty error}">
                    <p class="text-center text-success">${error}</p>
                    <c:remove var="error"/>
                </c:if>
            </div>
        </div>
    </div>
</div>
</body>
</html>
