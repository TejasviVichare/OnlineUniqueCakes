<%@page import="in.uc.dao.OrderDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.*,in.uc.pojo.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<% 
String uname=(String)session.getAttribute("username");

List<Cart>cartlist=(List<Cart>)session.getAttribute("clist");
String utype=(String)session.getAttribute("utype");
OrderDao dao= new OrderDao();
String msg=(String)request.getAttribute("msg");
if(msg!=null && msg.equals("Cart is empty")){
%>
<div class=""><p class="text-danger text-center"><%=msg %>&#128577;</p></div>
<%}else{ %>


<h1 class="text-center">Cart List</h1>
<table class="table table-bordered table-striped table-hover">
	<tr class="table-dark">

				<th>CakeName</th>
				<th>Cake Image</th>
				<th>Cake Type</th>
				<th>Cake category</th>
				<th>Cake flavour</th>
				<th>Cake weight</th>
				<th>Cake price</th>
				<th>Cake Quantity</th>				
			<th colspan=2>Cake operation</th>
	</tr>
<%for(Cart c:cartlist) {%>
	<tr>

		<td><%=c.getCake().getCakename() %></td>
		<td><img src="Cakeimage?cakeid=<%=c.getCake().getCakeid()%>" style="width:70px;height:70px"></td>
		<td><%=c.getCake().getCaketype() %></td>
		<td><%=c.getCake().getCakecategory() %></td>
		<td><%=c.getCake().getCakeflavour() %></td>
		<td><%=c.getCake().getCakeweight() %></td>
		<td><%=c.getCake().getCakeprice() %></td>
      	<td><input type="number" value="<%=c.getQuantity() %>" class="w-50"></td>
      	   <td><a href="" class="btn btn-success">Order</a></td>
           <td><a href="/OnlineUniqueCakes/cartc?action=deletefromcart&cartid=<%=c.getCartid() %>" class="btn btn-danger">Delete</a></td>
      
	   	  
	</tr>
  
  <%} %>
	<tr>
		<td colspan=9>Total Rs.<%=dao.getTotal(uname) %></td>
			<td><a href="/OnlineUniqueCakes/orderc?action=placeorder" class="btn btn-success">Order</a></td>
			
	</tr>
</table>
<%} %>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>