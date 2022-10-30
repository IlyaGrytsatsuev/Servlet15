<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: gratchuvalsky
  Date: 24.08.2022
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
  <link href="Style1.css" rel="stylesheet" type="text/css">
    <title>Advertisements</title>
  </head>
  <body>
  <%HttpSession s = (HttpSession)request.getAttribute("session");
    String name = (String)session.getAttribute("name");
    
  if(name=="Admin"){
  %>
  <a href="LogOut">Logout</a> 
  <a href="NewAd.html">Add New</a>
  <hr>
  <%
  } else {
  %>
  <a href="LoginLink.html">Login</a>
  <hr>
  <%
  }

   HashMap<String, String> tmp = (HashMap<String, String>)request.getAttribute("data");
  for(String key : tmp.keySet()) {%>
  <dl/>
    <dt><%= key %></dt>
    <dd><%= tmp.get(key) %></dd>
  </dl>
  <%}%>
  </body>
</html>
