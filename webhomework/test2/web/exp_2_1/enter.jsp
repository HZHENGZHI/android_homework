<%--
  Created by IntelliJ IDEA.
  User: wdnm_windows
  Date: 2020/9/24
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String uname=request.getParameter("username");
    String password=request.getParameter("userpass");
    String email=request.getParameter("email");
%>
<jsp:useBean id="user" class="Article.user"/>
<jsp:setProperty name="user" property="username" value="<%=uname%>"></jsp:setProperty>
<jsp:setProperty name="user" property="userpass" value="<%=password%>"></jsp:setProperty>
<jsp:setProperty name="user" property="email" value="<%=email%>"></jsp:setProperty>
用户名：<jsp:getProperty name="user" property="username"/>
密码：<jsp:getProperty name="user" property="userpass"/>
邮箱：<jsp:getProperty name="user" property="email"/>
</body>
</html>
