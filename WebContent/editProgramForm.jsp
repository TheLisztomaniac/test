<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Program</title>
<link rel="stylesheet" type="text/css" href="getTerm.css">
</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>
	
	<s:form method="post" action="editProgram">
		<table class="form">
			<tr><td><s:textfield key="ProgramId" label="Program Id" value="%{p.p_id}"/></td></tr>
			<tr><td><s:textfield key="p.p_name" label="Program Name" value="%{p.p_name}"/></td></tr>
			<tr><td><s:textfield key="p.p_code" label="Code" value="%{p.p_code}"/></td></tr>
			<tr><td><s:textfield key="p.duration" label="Duration" value="%{p.duration}"/></td></tr>
			<tr><td><s:select list="DurationUnit" name="p.duration_unit" label="Duration Unit" headerKey="-1" headerValue="Duration Unit"></s:select></td></tr>
			<tr><td><s:select list="facultyList" name="p.coordinator_id" label="Faculty" listKey="f_id" listValue="f_name" headerKey="-1" headerValue="Faculty"/></td></tr>
			<tr><td><s:textfield key="p.discription" label="Discription" value="%{p.discription}"/></td></tr>
			<tr><td></td><td><s:submit class = "submit-button" value="Edit Program"/></td></tr>		
	  	</table>
	</s:form>
</body>
</html>