<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.*,in.uc.pojo.Cake" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<% 
List<Cake>cakelist=(List<Cake>)session.getAttribute("clist");
String utype=(String)session.getAttribute("utype");

String msg=(String)request.getAttribute("msg");
if(msg!=null){
%>
<div class="alert alert-success"><%=msg %></div>
<%} %>

<h1 class="text-center">Cake List</h1>
<table class="table table-bordered table-striped table-hover">
	<tr class="table-dark">
		<th>Cake id</th>
				<th>CakeName</th>
				<th>Cake Image</th>
				<th>Cake Type</th>
				<th>Cake category</th>
				<th>Cake flavour</th>
				<th>Cake weight</th>
				<th>Cake price</th>
			<th colspan=2>Cake operation</th>
	</tr>
<%for(Cake c:cakelist) {%>
	<tr>
	<td><%=c.getCakeid() %></td>
		<td><%=c.getCakename() %></td>
		<td><img src="Cakeimage?cakeid=<%=c.getCakeid()%>" style="width:70px;height:70px"></td>
		<td><%=c.getCaketype() %></td>
		<td><%=c.getCakecategory() %></td>
		<td><%=c.getCakeflavour() %></td>
		<td><%=c.getCakeweight() %></td>
		<td><%=c.getCakeprice() %></td>
      <% if(utype!=null && utype.equals("admin")){ %>
      
	   <td><a href="/OnlineUniqueCakes/cakec?action=edit&cid=<%=c.getCakeid() %>" class="btn btn-success">Edit</a></td>
	   	<td><a href="/OnlineUniqueCakes/cakec?action=delete&cid=<%=c.getCakeid() %>" class="btn btn-danger">Delete</a></td>	 
	   	
	   <%} %>
	<td><a href="/OnlineUniqueCakes/cartc?action=addtocart&cid=<%=c.getCakeid() %>" class="btn btn-success">Add To Cart</a></td>	 
	   	  
	</tr>

  <%} %>

</table>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>