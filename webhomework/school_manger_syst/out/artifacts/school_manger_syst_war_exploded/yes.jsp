<%--
  Created by IntelliJ IDEA.
  User: wdnm_windows
  Date: 2020/10/11
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>
    登录成功

    <%
        if(session.getAttribute("userid")==null)
        {
            response.sendRedirect("test.jsp");
        }
    %>

    <%=session.getAttribute("userid")%>
    <%=session.getAttribute("pw")%>

</h2>

<form action="kkk.jsp">
<input type="submit" value="注销" >
</form>

</body>
</html>
