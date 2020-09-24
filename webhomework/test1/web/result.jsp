<%--
  Created by IntelliJ IDEA.
  User: wdnm_windows
  Date: 2020/9/23
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String result=request.getParameter("result");
    if(result.equals("0")){
%>
<p>yes</p>
<%
    }else {
%>
<p>
    no
</p>
<%
    }
%>
</body>
</html>
