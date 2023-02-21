<%@page import="in.uc.pojo.Order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<%
Order o=(Order)session.getAttribute("order");
String msg=(String)request.getAttribute("msg");
if(msg!=null){
%>
<div class="alert alert-success alert-dismissable fade show" role="success">
	<strong>success!</strong><%=msg %>
	<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
</div>
<%} %>
<table class="table table-striped">
<tr>
	<th>Order Id</th>
	<th>Order date</th>
	<th>Order status</th>
	<th>Order Total</th>

</tr>
<tr>
	<td><%=o.getOrderid()%></td>
	<td><%=o.getOrderdate()%></td>
	<td><%=o.getOrderstatus()%></td>
	<td><%=o.getOrdertotal()%></td>

</tr>
</table>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>