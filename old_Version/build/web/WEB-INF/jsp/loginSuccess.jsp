<%-- 
    Document   : loginSuccess
    Created on : 10-Jul-2017, 12:59:19
    Author     : asifmuztaba
--%>
<%@page import="com.police.entity.PUser"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
   PUser user=(PUser) session.getAttribute("session");
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login Successful...</h1><br>
        <p><%= user.getEmail()%></p>
        <p><%= user.getPassword()%></p>
<p>ID:<%= user.getId() %></p>  

 <p><%= user.getName() %></p>
 <p><%= user.getRole() %></p>
 
 <a href="logout">Log out</a>              
        
    </body>
</html>
