<%@ page contentType="text/html;charset=utf-8" %>
<HTML>
<BODY BGCOLOR=green>
<FONT Size=3>
<br> 英文字母表：<br>
    <%   char c ='A';
         for(c='A';c<='Z';c++) {
            out.print(" "+c);
            if(c=='M')
              out.print("<br>");
         }
    %>
</FONT></BODY></HTML>