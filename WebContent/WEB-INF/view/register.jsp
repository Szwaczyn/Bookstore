<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"
     prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"
     prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register user</title>
</head>
<body>
	<h1>Register user</h1>
	${error }
	<form method="post">
		<p>Login:</p>
		<input type="text" name="login"/>
		<p>Password</p>
		<input type="password" name="password"/>
		<p>Repeat password</p>
		<input type="password" name="password2"/>
		<br>
		<input type="submit" value="Create user"/>
	</form>
</body>
</html>