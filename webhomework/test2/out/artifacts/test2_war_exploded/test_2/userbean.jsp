<%--
  Created by IntelliJ IDEA.
  User: wdnm_windows
  Date: 2020/9/24
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:useBean id="acticle" class="Article.Article"/>
<jsp:setProperty name="acticle" property="id" value="520"/>
<jsp:setProperty name="acticle" property="author" value="关系kkk"/>
<jsp:setProperty name="acticle" property="title" value="看看看看"/>

<p>
  作者：  <jsp:getProperty name="acticle" property="id"/>
    标题<jsp:getProperty name="acticle" property="title"/>
    作者<jsp:getProperty name="acticle" property="author"/>

</p>
</body>
</html>
