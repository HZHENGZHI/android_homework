<%--
  Created by IntelliJ IDEA.
  User: wdnm_windows
  Date: 2020/9/23
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" import="java.util.*"
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String email=request.getParameter("email");
    if(email.equals(""))
    {
%>
1111111
1111

<jsp:forward page="result.jsp">
    <jsp:param name="result" value="0"/>
<%--    param用于传递参数 name为参数名称，value代表传递的参数值--%>
</jsp:forward>
<%
}else {%>
<%--
forward将请求转发到可以处理这个请求的文件上
--%>
<jsp:forward page="result.jsp">
    <jsp:param name="result" value="1"/>
    <jsp:param name="email" value="<%=email%>"/>
</jsp:forward>
<%}%>

</body>
</html>
