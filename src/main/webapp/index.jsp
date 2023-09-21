<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng nhập</title>
    <%@include file="css.jsp"%>
</head>
<body>
<div class="container p-4">
        <div class="row" style="margin-top:10px;">
            <div class="content" style="height: 1090px; width: 960px; margin: auto">
                    <h1>Sign in</h1>
                <div class="body" style="margin-top: 10px">
                    <form method="post" action="login">
                            <label for="username" class="control-label col-xs-3">Email: </label>
                            <input type="text" class="form-control" name="username" id="username" style="width: 600px"
                                   placeholder="Email"/>


                            <label for="password" class="control-label col-xs-3" >Password: </label>
                            <input type="password"  class="form-control" name="password" id="password" style="width: 600px"
                                   placeholder="Password"/>


                            <input type="submit" name="signin" id="signin" style="color: white; margin-top: 10px; background-color: blue; width: 100px;"
                                   class="btn btn-group-justified" value="Log in"/>
                            <input type="reset" name="clear" id="clear" style="color: white; margin-top: 10px; background-color: blue; width: 100px;"
                                   class="btn btn-group-justified" value="Clear"/>


                        <c:if test="${not empty status}">
                            <p class="text-center text-success">${status}</p>
                            <c:remove var="status"/>
                        </c:if>
                        <c:if test="${not empty status2}">
                            <p class="text-center text-success">${status2}</p>
                            <c:remove var="status2"/>
                        </c:if>
                    </form>

            </div>
            </div>

        </div>
</div>

</body>
</html>