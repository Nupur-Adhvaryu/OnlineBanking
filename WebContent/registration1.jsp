<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.info{
font-size: 24px;
}
#submit{
text-align :"center";
}
</style>
<link type="text/css" rel="stylesheet" href="style/main.css">
</head>

<body>
<div class = "title">

<img src = "F.jpeg">
</div>

<div class = "info">
<% Cookie[] c = request.getCookies();
Cookie name = null;
Cookie id = null;
if(c!=null){

	for(Cookie cookie:c){
		if(cookie.getName().equals("user")){
			 name = cookie;
		%> Hello <%=cookie.getValue() %><%
		}
	}

for(Cookie cookie:c){
	if(cookie.getName().equals("id")){
		out.println(" ");
		 id = cookie;
		%> Your Id is -  <%=cookie.getValue() %><%
		}
}
}
if(name == null&&id==null){
	response.sendRedirect("SessionTimeOutError.jsp");
}

%>

</div>
<form action = "MainPageProcessor" method = "POST">

<input id = "submit" type = "submit" name = "submit" value = "Start Banking">

</form>

</body>
</html>