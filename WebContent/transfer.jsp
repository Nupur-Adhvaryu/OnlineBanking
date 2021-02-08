<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="style/main.css">
</head>
<body>
<form action="TransferMoney" >
Select The Account To send money From<select name ="id" required>
<option value = "" >Account--Type--Amount</option>
<c:forEach var="A" items ="${cAcc}">
<option value="${A.id}">${A.id}--${A.type}--${A.amt}</option> 
</c:forEach>
<c:forEach var="A" items ="${sAcc}">
<option value="${A.id}">${A.id}--${A.type}--${A.amt}</option> 
</c:forEach>
</select><br>
Enter the account ID<input type = "text" name = "otherId" required><br>
Enter the Amount you want to put in the account<input type = "number" name = "amt" required><br>
<input type ="submit" value ="submit" name = "confirm">
</form>
</body>
</html>