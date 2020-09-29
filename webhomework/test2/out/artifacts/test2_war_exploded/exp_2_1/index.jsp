<%--
  Created by IntelliJ IDEA.
  User: wdnm_windows
  Date: 2020/9/24
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="check.jsp" method="post">
    <div class="content">
        <p>
            <label for="email"> 登录名:</label>
            <input  class="input" type="text" id="username" maxlength="32" name="username">
        </p>
        <p>
            <label for="email">登录密码:</label>
            <input class="input" style="width: 148px" type="password" maxlength="16" id="passwoed" name="userpass">
        </p>
        <p>
            <label for="email">登录确认:</label>
            <input class="input" style="width: 148px" type="password" maxlength="16" id="passwoed2" name="userpass2">
        </p>
        <p>
            <label for="email">电子邮箱</label>
            <input id=email maxlength="32" class="input" name=email>
        </p>
        <p>
            <input type="submit" name="mysubmit" value="lkkk" class="tj">
        </p>
    </div>
</form>
</body>
</html>
