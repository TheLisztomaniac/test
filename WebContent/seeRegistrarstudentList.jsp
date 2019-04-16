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

	<s:if test="%{Student.size()==0}">
		<h4>No <s:property value="%{heading}"/> Student</h4>
	</s:if>
	<s:else>
		<h4><s:property value="%{heading}"/> Students Profile</h4>

		<s:form method="post" action="Registrar">
			<table>
				<tr>
					<th>Sr No</th>
					<th>Student Id</th>
					<th>Name</th>
					<th>DOB</th>
					<th>Gender</th>
					<th>Blood Group</th>
					<th>Address</th>
					<th>Height</th>
					<th>Mobile No</th>
				</tr>
				
				<s:set var="c" value="1"/>
				
				<s:iterator var="i" value="Student">
					<tr>
						<td><s:property value="#c"/></td>
						<td><s:property value="#i.std_id"/></td>
						<td><s:property value="#i.std_name"/></td>
						<td><s:property value="#i.birth_date"/></td>
						<td><s:property value="#i.gender"/></td>
						<td><s:property value="#i.blood_grp"/></td>
						<td><s:property value="#i.address"/></td>
						<td><s:property value="#i.height"/></td>
						<td><s:property value="#i.contact_number"/></td>
						<s:set var="c" value="%{#c + 1}"/>
					</tr>
				</s:iterator>
			</table>
			<br>
			<s:submit value="back"/>
		</s:form>
	</s:else>
</body>
</html>