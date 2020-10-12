<%--
  Created by IntelliJ IDEA.
  User: wdnm_windows
  Date: 2020/10/11
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>
        <%
            String pw=request.getParameter("pw");
            String name=request.getParameter("username");
        if(name.equals("admin") && pw.equals("888888"))
            {
                response.sendRedirect("yes.jsp");
                session.setAttribute("userid",name);
                session.setAttribute("pw",pw);
            }
        else
        {
            response.sendError(400,"登录失败");
        }
            System.out.println(pw);
            System.out.println(name);
        %>
    </p>
</body>
</html>
