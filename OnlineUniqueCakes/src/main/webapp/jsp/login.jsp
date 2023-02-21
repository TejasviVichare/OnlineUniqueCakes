<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>login page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link href='https://fonts.googleapis.com/css?family=Sofia' rel='stylesheet'>
<style>

body {
    font-family: 'Sofia';font-size: 22px;
}
</style>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<%
String msg=(String)request.getAttribute("msg");
if(msg!=null){
%>
<div class="alert alert-danger"><%=msg %></div>
<%} %>

<div class="container mb-3 shadow-lg p-3 mb-5 bg-body rounded mt-5" style="width:400px">
<p class="text-primary text-center h2 m-3 fw-bold">Login Form</p>
<form action="/OnlineUniqueCakes/loginc" method="post">
  <div class="mb-3">
    <label for="exampleInputEmail1" class="form-label mt-2">Email address</label>
    <input type="email" class="form-control" name="username" id="exampleInputEmail1" aria-describedby="emailHelp">
  </div>
  <div class="mb-2">
    <label for="exampleInputPassword1" class="form-label">Password</label>
    <input type="password" class="form-control" name="userpass" id="exampleInputPassword1">
  </div>
  <div class="mb-2">
    <label for="exampleInputEmail1" name="usertype" class="form-label mt-2">user type</label>
  </div>
  <div class="form-check float-start me-5">
  <input class="form-check-input" type="radio" name="usertype" id="flexRadioDefault1" value="admin">
  <label class="form-check-label" for="flexRadioDefault1">
    admin
  </label>
</div>
<div class="form-check">

  <input class="form-check-input " type="radio" name="usertype" id="flexRadioDefault2" value="customer">
  <label class="form-check-label" for="flexRadioDefault2">
    customer
  </label>
</div>
  <button type="submit" class="btn btn-primary w-100 mt-3 mb-3">login</button>
  <a href="register.jsp" >New User??</a>
  <a href="/OnlineUniqueCakes/jsp/forgotpassword.jsp" > Forgot Password ??</a>
  
</form>
</div>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
