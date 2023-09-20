<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<input type="hidden" id="status"
       value="<%=request.getAttribute("status")%>">
<div class="main">
    <section class="sign-in">
        <div class="container">
            <div class="signin-content" style="text-align: center">
                    <h1>Sign in</h1>
                    <form method="post" action="login"
                          id="login-form">
                        <div class="form-group">
                            <label for="username" style="width: 200px; height: 50px; margin-left: 21px">Email: </label>
                            <input type="text" style="width: 200px;  margin-bottom: 10px" name="username" id="username"
                                   placeholder="Email"/>
                        </div>
                        <div class="form-group">
                            <label for="password" style="width: 200px" >Password: </label>
                            <input type="password" style="width: 200px ;margin-bottom: 10px" name="password" id="password"
                                   placeholder="Password"/>
                        </div>
                        <div class="form-group form-button">
                            <input type="submit" name="signin" id="signin" style="margin-bottom: 10px; margin-right: 33px"
                                   class="form-submit" value="Log in"/>
                            <input type="reset" name="clear" id="clear" style="margin-bottom: 10px;"
                                   class="form-submit" value="Clear"/>
                        </div>

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
    </section>
</div>

</body>
</html>