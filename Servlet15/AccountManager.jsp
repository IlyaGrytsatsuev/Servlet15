<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: gratchuvalsky
  Date: 24.08.2022
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

  <body>
  <script src="AccountDelete.js"></script>
      
  <a href="Ads">Home</a> 
  <a href="LogOut">Logout</a> 
  <a href="NewAd.html">Add New</a>
  <hr>
  
  Accounts:
  
  <% HashMap<String, String> accounts = (HashMap<String, String>)request.getAttribute("data");
  for(String key : accounts.keySet()) {%>
  <div id="<%=key%>Account">
  <dl>
    <dt> <%= key %></dt>
    <input type="button"  id="<%=key%>Button" value="Delete" onclick="Delete('<%=key%>')"/>
   </dl>
   </div>
  <%}%>
  </body>
</html>
