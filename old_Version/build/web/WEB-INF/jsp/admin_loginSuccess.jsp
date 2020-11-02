<%-- 
    Document   : loginSuccess
    Created on : 10-Jul-2017, 12:59:19
    Author     : asifmuztaba
--%>


<%@page import="com.police.entity.PsUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
   PsUser user=(PsUser) session.getAttribute("session");
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login Successful...</h1><br>
        <p><%= user.getUsername() %></p>
        <p><%= user.getPassword()%></p>
<p>ID:<%= user.getId() %></p>  

 <p><%= user.getDivision() %></p>
 <p><%= user.getRole() %></p>
 
                
        
    </body>
</html>
