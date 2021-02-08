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
display : flex;
width : 100%;
background-color : rgb(50,185,207);
 border: none;
  border-radius: 10px;

}


h1 {
width : 70%;
padding : 0px;
text-align : center ;
font-size : 62px;

}

.login , .register {
padding : 7px ;
text-align : center;

}
label {
padding : 3px;
font-size : 20px;
}

</style>
</head>
<body>
<div class = "title">
<h1 > Welcome </h1>
<img src = "F.jpeg">
</div>

 <br><br>
 <div class = "container">
 <div class = " login">
<form action ="MainPageProcessor" method = "POST">
<label>User Id     </label><input type = "text" name = "userid"> <br/><br/>
<label>Password    </label><input type = "password" name = "pass"> <br/><br/>
<input type = "submit" name = "submit" value = "Login"> <br/>
</form>
</div>

<div class = "register">
<form action ="registration.jsp" method = "POST">
<input type = "submit" name = "submit" value = "Register Online">
</form> 
</div>
</div>
</body>
</html>