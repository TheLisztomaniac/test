<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Schedule</title>
</head>
<body>
	
	<s:form method="post" action="UpdateRegistrarSchedule">
		<table>
			<tr><td><s:textfield name="selectedTerm" value="%{selectedTerm}" label="Term"/></td></tr>
			<tr><td><s:textfield name="selectedAcad" value="%{selectedAcad}" label="Academic Year"/></td></tr>
			<tr><td><s:textfield name="openRegistraton" label="Open Add/Drop"/></td></tr>
			<tr><td><s:textfield name="closeRegistraton" label="Close Add/Drop"/></td></tr>
			<tr><td><s:select list="reminder" name="selectedReminder" label="Set Reminder"/></td></tr>
			<tr><td><s:submit value="Submit Schedule"/></td></tr>
		</table>
	</s:form>

</body>
</html>