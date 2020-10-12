<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: wdnm_windows
  Date: 2020/10/11
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  %>
<html>
<head>
    <title>登录</title>
</head>
<body>

<form action="check.jsp" method="post" id="apform">
    <label>用户名</label>
    <%
        Object name="";
        if(session.getAttribute("userid")!=null)
        {
            name=session.getAttribute("userid");
        }

    %>
    <input type="text" name="username" value="<%=name%>">
    <label>密码</label>
    <INPUT type="password" name="pw" value="<%=session.getAttribute("pw")%>">
    <input type="submit" value="登录">
</form>

<%=session.getId()%>
</body>
</html>
