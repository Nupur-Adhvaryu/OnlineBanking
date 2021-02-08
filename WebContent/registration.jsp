<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>----- Bank</title>
<link type="text/css" rel="stylesheet" href="style/main.css">
<style type="text/css">
.title {
text-align : center;
padding : 5px;
}


</style>



</head>
<body>

<div class = "title">

<img src = "F.jpeg">
</div>

<div class = "newuser">
<h3> Please enter your information </h3>
<br/>

<form action = "registration" method = "POST" >
<label>First Name </label> 
<input type= "text" name = "fname" required><br>
<label>Last Name </label> 
<input type= "text" name = "lname" required><br>
<label>Email</label>
<input type= "email" name = "email" required><br>
<label>Address</label>
<input type= "text" name = "add" required><br>
<label>Postal Code</label>
<input type="text" name = "pcode" placeholder="A1A1A1" pattern= "[A-Za-z][0-9][A-Za-z][0-9][A-Za-z][0-9]" required><br>
<label>Date Of Birth</label>
<input type="date" name = "birth" required><br>
<label>Password </label>
<input type= "password" name = "pass" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required><br>
<label>SIN number</label>
<input type = "number" name = "sin" max="999999999" min="100000000"  required><br>

Adding the initial amount <br>

$ <input type = "number" name = "amt" placeholder ="atleast $100" min ="100" required >
<input type = "submit" name = "submit" value = "Confirm">

</form>

</div>

</body>
</html>