<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
Cookie[] c = request.getCookies();
if(c!=null){

	for(Cookie cookie:c){
		if(cookie.getName().equals("user")){
			String fName =cookie.getValue();
		%> Hello <%=fName %><%
		}
	}
	
}
for(Cookie cookie:c){
	if(cookie.getName().equals("id")){
		String id =cookie.getValue();
		%> Your Id is -  <%=id %><%
		}
}

%>
</body>
</html>