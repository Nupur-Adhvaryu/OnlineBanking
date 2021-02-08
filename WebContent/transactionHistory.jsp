<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link type="text/css" rel="stylesheet" href="style/main.css">
<body>
<h2>Sent History</h2>
<table> 
<tr> 
<th>Sent</th>
<th>To</th>
<th>Amount</th>
<th>Date</th>
</tr>

<c:forEach var = "t" items = "${sent}">
<tr>
<td>${t.gId } </td>
<td>${t.rId } </td>
<td>${t.amt } </td>
<td>${t.dateCreated } </td>

</tr>

</c:forEach>



</table>
<h2>Recieved History</h2>
<table> 
<tr> 
<th>Recieved</th>
<th>From</th>
<th>Amount</th>
<th>Date</th>
</tr>

<c:forEach var = "t" items = "${recieved}">
<tr>
<td>${t.rId } </td>
<td>${t.gId } </td>
<td>${t.amt } </td>
<td>${t.dateCreated } </td>

</tr>

</c:forEach>



</table>
</body>
</html>