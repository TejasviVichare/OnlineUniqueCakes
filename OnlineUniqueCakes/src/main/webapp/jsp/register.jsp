<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<%
String msg=(String)request.getAttribute("msg");
if(msg!=null){
%>
<div class="alert alert-success"><%=msg %></div>
<%} %>

<div class="container shadow-lg p-3 mb-5 bg-body rounded mt-5" style="width:400px">
<p class="text-center fs-2 text-danger"><b>Registration Form</b></p>
<form action="/OnlineUniqueCakes/custc" method="post">
<input type="hidden" name="action" value="addcustomer">

  <div class="mb-3 ">
    <label for="exampleInputEmail1" class="form-label">Enter Name</label>
    <input type="text" name="custname" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
  </div>
  
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Enter email</label>
    <input type="email" name="custemail" class="form-control" id="exampleInputPassword1">
  </div>
  
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Enter contact</label>
    <input type="text" name="custcontact" class="form-control" id="exampleInputPassword1">
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Enter address</label>
    <input type="text" name="custaddress" class="form-control" id="exampleInputPassword1">
  </div>
  <div class="mb-3">
    <label for="exampleInputPassword1" class="form-label">Enter password</label>
    <input type="password" name="custpassword" class="form-control" id="exampleInputPassword1">
  </div>
  <button type="submit" class="btn btn-primary w-100">Register</button>
</form>
</div>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>