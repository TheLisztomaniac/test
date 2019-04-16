<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
</head>
<body>
	<h3>You have already registered !</h3>
	<s:form method="post" action="getStudentRegistration">
		<s:hidden name="selectedSemester" value="%{selectedSemester}"/>
		<s:hidden name="StudentId" value="%{StudentId}"/>
		<s:hidden name="adddrop" value="%{adddrop}"/>
		<s:submit value="Click here to course-edjustment"/>
	</s:form>
</body>
</html>