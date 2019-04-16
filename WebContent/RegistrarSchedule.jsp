<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar Schedule</title>
</head>
<body>
	<s:form method="post">
		<table>
			<tr><td><s:select list="term" name="selectedTerm" listKey="taid.t_name" listValue="taid.t_name" label="Term" headerKey="-1" headerValue="Term"/></td></tr>
			<tr><td><s:select list="acad" name="selectedAcad" listKey="a_year" listValue="a_year" label="Academic Year" headerKey="-1" headerValue="Acad"/></td></tr>
			<tr><td><s:submit value="Schedule Registration" action="RegistrarScheduleForm" theme="simple"/></td><td><s:submit value="Schedule Add/Drop" action="RegistrarScheduleForm1" theme="simple"/></td></tr>
		</table>
	</s:form>
</body>
</html>