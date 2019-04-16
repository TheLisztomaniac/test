<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Profile</title>
<link href = "getTerm.css" type = "text/css" rel = "stylesheet">
</head>
<body>
	
	<s:form method="post" action="editStudent">
		<table class = "gridtable">
			<tr><td>Student Id</td><td><s:textfield name="Student.std_id" value="%{Student.std_id}" theme="simple"/></td></tr>
			<tr><td>Student Name</td><td><s:textfield name="Student.std_name" value="%{Student.std_name}" theme="simple"/></td></tr>
			<tr><td><s:select list="batch" name="Student.batch_name" label="Batch" listKey="pbid.batch_name" listValue="pbid.batch_name" headerKey="-1" headerValue="Batch"/></td></tr>
			<tr><td><s:select list="program" name="Student.p_id" label="Program" listKey="p_id" listValue="p_name" headerKey="-1" headerValue="Program"/></td></tr>
			<tr><td>Gender</td><td><s:textfield name="Student.gender" value="%{Student.gender}" theme="simple"/></td></tr>
			<tr><td>Birth Date</td><td><s:textfield name="Student.birth_date" value="%{Student.birth_date}" theme="simple"/></td></tr>
			<tr><td>Contact Number</td><td><s:textfield name="Student.contact_number" value="%{Student.contact_number}" theme="simple"/></td></tr>
			<tr><td>Height</td><td><s:textfield name="Student.height" value="%{Student.height}" theme="simple"/></td></tr>
			<tr><td>Id Mark</td><td><s:textfield name="Student.id_mark" value="%{Student.id_mark}" theme="simple"/></td></tr>
			<tr><td>Blood Group</td><td><s:textfield name="Student.blood_grp" value="%{Student.blood_grp}" theme="simple"/></td></tr>
			<tr><td>Address</td><td><s:textfield name="Student.address" value="%{Student.address}" theme="simple"/></td></tr>
			<s:submit class = "submit-button" value="Edit Profile"/>
		</table>
	</s:form>
</body>
</html>