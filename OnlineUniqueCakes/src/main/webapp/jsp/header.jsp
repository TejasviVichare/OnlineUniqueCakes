<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>www.uniquecakes.com</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<%
String utype=(String)session.getAttribute("utype");
String username=(String)session.getAttribute("username");

%>
<!-- A grey horizontal navbar that becomes vertical on small screens -->
<nav class="navbar navbar-expand-sm bg-warning">

  <div class="container-fluid">
    <!-- Links -->
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="#">HOME</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">ABOUT US</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/OnlineUniqueCakes/cakec">CAKES</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">CONTACT</a>
      </li>
      
      <% if(utype!=null && utype.equals("customer")){ %>
      <li class="nav-item">
        <a class="nav-link" href="#">PROFILE</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/OnlineUniqueCakes/cartc?action=mycart">MYCART</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/OnlineUniqueCakes/orderc?action=myorders">MYORDERS</a>
      </li>
      <%} %>
      
      <% if(utype!=null && utype.equals("admin")){ %>
      <li class="nav-item">
        <a class="nav-link" href="/OnlineUniqueCakes/jsp/addcakes.jsp">ADD CAKE</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">CAKELIST</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">CUSTOMERLIST</a>
      </li>
      <%} %>
      
      <% if(utype!=null){ %>
      <li class="nav-item">
        <a class="nav-link" href="/OnlineUniqueCakes/loginc">LOGOUT</a>
      </li>
      <% }else {%>
       <li class="nav-item">
        <a class="nav-link" href="/OnlineUniqueCakes/jsp/login.jsp">LOGIN</a>
      </li>
      
       <%}%>
      <%if(username!=null){ %>
      <li class="nav-item ms-5">
        <a class="nav-link">Welcome <%=username %></a>
      </li>
      <%} %>
    </ul>
  </div>

</nav>
</body>
</html>