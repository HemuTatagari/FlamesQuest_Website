<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@page import="java.sql.Connection" %>
    <%@page import="java.sql.DriverManager" %>
    <%@ page import="java.sql.PreparedStatement" %>
    <%@ page import="java.sql.ResultSet" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="OutputStyle.css">
<title>FlameQuest | Result Page</title>
</head>
<body >
<h2>FlamesQuest</h2>
<img src="images\Sisters.jpeg"/>

<h3> Connection between you both is: " ${relation}"</h3>
<h3>
 Connection intensity:"${percentage} ".</h3>

</body>
</html>