<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="style/main.css">
<meta charset="UTF-8">
<title>Create A New Account</title>
</head>
<body>
<h1>Create new Account</h1>

<form action="AddAcc" >
Select the Account you Want to Create<select name = "type" required>
<option value ="Checking">Checking</option>
<option value ="Saving">Saving</option>
</select> <br>
Select The Account To Withdraw From<select name ="id" required>
<option value = "" >Account--Type--Amount</option>
<c:forEach var="A" items ="${cAcc}">
<option value="${A.id}">${A.id}--${A.type}--${A.amt}</option> 
</c:forEach>
<c:forEach var="A" items ="${sAcc}">
<option value="${A.id}">${A.id}--${A.type}--${A.amt}</option> 
</c:forEach>
</select><br>
Enter the Amount you want to put in the account<input type = "number" name = "amt" required><br>
<input type ="submit" value ="submit" name = "confirm">
</form>
</body>
</html>