<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<link type="text/css" rel="stylesheet" href="style/main.css">
<head>
<meta charset="ISO-8859-1">
<title>YOUR PROFILE</title>

</head>
<div class = "title">
<img src = "F.jpeg">
</div>
<body>

<h2> This is your personal information</h2>
 
 <h4>
 First Name : ${user.fName}<br>
 Last Name  : ${user.lName}<br>
 EmailID    : ${user.email}<br>
 Address    : ${user.add}<br>
 PostalCode : ${user.pCode}<br>
 Birth Date : ${user.birth}<br>
 Amount     : ${user.amt}

</h4>
</body>
</html>