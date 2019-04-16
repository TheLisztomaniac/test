<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar</title>
</head>
<body>
	<s:form method="post">
		<table>
			<tr><td><s:select list="program" name="selectedProgram" label="Program" listKey="p_id" listValue="p_name" headerKey="-1" headerValue="Program"/></td></tr>
			<tr><td><s:select list="batch" name="selectedBatch" label="Batch" headerKey="-1" headerValue="Batch"/></td></tr>
			<tr><td><s:select list="semester" name="selectedSemester" label="Select Semester" headerKey="-1" headerValue="Semester"/></td></tr>
			<tr>
				<td><s:submit value="Registration List" theme="simple" action="getRegistrarForm"/></td>
				<td><s:submit value="Unregistration List" theme="simple" action="getUnRegistrarForm"/></td>
				<td><s:submit value="Registered Students Profile" theme="simple" action="seeRegistrarstudentList"/></td>
				<td><s:submit value="Unregistered Students Profile" theme="simple" action="seeRegistrarstudentList1"/></td>
			</tr>
			<s:hidden name="check" value="0"/>
		</table>
	</s:form>
</body>
</html>