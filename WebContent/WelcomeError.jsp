<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title> _____ Bank</title>

<style type="text/css">

.title {
display : flex;
}

img {
width :30%;
padding :px;
}

h1 {
width : 70%;
padding : 5px;
text-align : center ;
}
 h4 {
 text-align : center;
 border :2px solid red ;
 background-color :ffcccc;
 padding : 10px;
 }

.login , .register {
padding : 7px ;
text-align : center;

}
label {
padding : 3px;
}

</style>
<% Cookie[] c = request.getCookies();
int i = 5;
if(c!=null){
	for(Cookie cookie:c){
		System.out.print(cookie.getName());
		if(cookie.getName().equals("error")){
			i = Integer.parseInt(cookie.getValue());
		}
	}
	}
%>
</head>
<body>
<div class = "title">
<h1 > Welcome to ____ Bank </h1>
<img src = "hello.jpg">
</div>

<div class = "error"> 
<h4> Userid or Password entered is incorrect. please add the right one.  <%=i%> consecutive attempts of wrong information will block your account</h4>
</div>

 <br><br>
 <div class = "container">
 <div class = " login">
<form action ="MainPageProcessor" method = "POST">
User Id<input type = "text" name = "userid"> <br/><br/>
Password<input type = "password" name = "pass"> <br/><br/>
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