<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registration Portal</title>
</head>
<body>
	<h3>Student Id : <s:property value="%{StudentId}"/></h3><br>
	<h3>Semester : <s:property value="%{selectedSemester}"/></h3><br><br>
	
	<h4>Core Course</h4>
	<table class="gridtable">
		
	</table>
	
</body>
</html>