<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Login page</h1>
	
	<form method="post" action="j_security_check">
		<p>Login</p>
		<input type="text" name="j_username"/>
		<p>Password</p>
		<input type="password" name="j_password"/> <br>
		<input type="submit" value="Login"/>
	</form>
	<a href="newuser">Create account</a>
</body>
</html>