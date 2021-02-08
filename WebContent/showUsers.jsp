<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>User database</title>
</head>
<link type="text/css" rel="stylesheet" href="style/main.css">
<body>
<img src = "F.jpeg">
<table> 
<tr> 
<th> UserId</th>
<th> First Name</th>
<th> Last Name</th>
<th> Email ID </th>
<th> Address</th>
<th> Postal Code</th>
<th> Amount total</th>
</tr>

<c:forEach var = "user" items = "${users}">
<tr>
<td> ${user.id}</td>
<td> ${user.fName}</td>
<td> ${user.lName}</td>
<td> ${user.email}</td>
<td> ${user.add}</td>
<td> ${user.pCode}</td>
<td> ${user.amt}</td>

</tr>

</c:forEach>




</table>

</body>
</html>