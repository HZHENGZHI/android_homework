<%--
  Created by IntelliJ IDEA.
  User: wdnm_windows
  Date: 2020/9/24
  Time: 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%!
    boolean checkexistsname(String name)
    {
        return name.equals("zhht");
    }
%>
<%
    request.setCharacterEncoding("utf-8");
    String uname=request.getParameter("username");
    String userpass=request.getParameter("userpass");
    String email=request.getParameter("email");
%>
<%
    if(checkexistsname(uname))
    {
%>
<jsp:forward page="header.jsp"></jsp:forward>
<%
    }
    {
%>
<jsp:forward page="enter.jsp">
    <jsp:param name="username" value="<%=uname%>"/>
    <jsp:param name="userpass" value="<%=userpass%>"/>
    <jsp:param name="email" value="<%=email%>"/>
</jsp:forward>
<%
    }
%>
</body>
</html>
