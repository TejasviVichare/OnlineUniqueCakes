<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="in.uc.pojo.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>

<%
List<Order> olist=(List<Order> )session.getAttribute("olist");
String utype=(String)session.getAttribute("utype");

String msg=(String)request.getAttribute("msg");
if(msg!=null && msg.equals("order details not found")){
%>
<p class="text-danger text-center m-3 fw-bold"><%=msg %> &#128577;</p>
<%}else{ %>
<h1 class="text-center text-primary">My Order history</h1>
<table class="table table-bordered table-hover container table-striped" style="width:80%">

<tr class="table-dark">

<th>Cake Name</th>
   <th>Cake Image</th>
<th>Cake Type</th>
<th>Cake Category</th>
<th>Cake Flavour</th>
<th>Cake Weight</th>
<th>Cake Price</th>
<th>Food Quantity</th>
<th>Orderdate</th>
<th>Order total</th>
<th>Order status</th>

</tr>
<%for(Order o:olist){ %>
<tr>

   <td><%=o.getCake().getCakename() %></td>
   <td><img src="/OnlineUniqueCakes/cakeimage?cakeid=<%=o.getCake().getCakeid()%>" width="80" height="100" /> </td>
   <td><%=o.getCake().getCaketype() %></td>
   <td><%=o.getCake().getCakecategory() %></td>
   <td><%=o.getCake().getCakeflavour() %></td>
   <td><%=o.getCake().getCakeweight() %></td>
   <td><%=o.getCake().getCakeprice() %></td>
  <th><%=o.getCart().getQuantity() %></th>
  <th><%=o.getOrderdate() %></th>
  <th><%=o.getOrdertotal()%></th>
  <th><%=o.getOrderstatus() %></th>
</tr>
<%} %>
</table>
<%} %>
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
