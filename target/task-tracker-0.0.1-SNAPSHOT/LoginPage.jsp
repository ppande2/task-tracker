<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Task Tracker</title>
</head>

<body>

<h1>Pankaj Pandey</h1>

<form action="http://localhost:8080/task-tracker/login" method="POST">
<label for="userId">UserId</label>
<input name="userId" />
<br/>
<label for="password">Password</label>
<input name="password" />
<br/>
<input type="submit" value="Submit" />
</form>

	

</body>
</html>