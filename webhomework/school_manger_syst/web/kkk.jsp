<%--
  Created by IntelliJ IDEA.
  User: wdnm_windows
  Date: 2020/10/11
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    session.removeAttribute("userid");
    session.removeAttribute("pw");
    response.sendRedirect("test.jsp");
%>
</body>
</html>
