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

	<s:url action="editStudentProfile" var="d_url" escapeAmp="false">
		<s:param name="StudentId" value="%{StudentId}"/>
	</s:url>
	<a href='<s:property value = "#d_url"/>'>Edit Profile</a>
	<br><br>

	<s:form method="post">
		<table>
			<tr><td><s:textfield name="StudentId" value="%{StudentId}" label="Student Id"/></td></tr>
			<tr><td><s:select list="Semester" name="selectedSemester" label="Select Semester" headerKey="-1" headerValue="Semester"/></td></tr>
			<tr><td><s:submit value="Register" action="getStudentRegistration" theme="simple"/></td><td><s:submit value="Result" action="getStudentResult" theme="simple"/></td></tr>
		</table>
	</s:form>
	
</body>
</html>