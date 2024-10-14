<%@ page import="java.sql.ResultSet" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>All Registration</h2>
<table>
<tr>
<th>Name</th>
<th>Email</th>
<th>Mobile</th>
<th>delete</th>
<th>update</th>

</tr>
<%
ResultSet result=(ResultSet)request.getAttribute("result");
while(result.next()){%>
	<tr>
	<td><%=result.getString(1) %></td>
		<td><%=result.getString(2) %></td>
	<td><%=result.getString(3) %></td>
	<td> <a href="deletereg?email=<%=result.getString(2) %>">delete</a></td>
		<td> <a href="updatereg?email=<%=result.getString(2)%>&mobile=<%=result.getString(3)%>">update</a></td>
	</tr>
	


<% }%>
</table>

</body>
</html>