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
<h2> update Registration......</h2>
<form action="updatereg" method="post">
<table>

<tr>
<td>Email</td>
<td><input type="text" name="email" value="<%=request.getAttribute("email")%>" readonly></td>
</tr>
<tr>
<td>Mobile</td>
<td><input type="text" name="mobile" value="<%=request.getAttribute("mobile")%>"/></td>
</tr>
<td><input type="submit" value="update"/></td>

</table>

</form>


</body>
</html>