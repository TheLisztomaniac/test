<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UnRegistrar</title>
</head>
<body>

	<s:if test="%{StudentId.size() == 0}">
		<h3>No Student registered !</h3>
	</s:if>
	<s:else>
		<s:form method="post" action="ConformUnRegistrar">
			<table>
				<tr><td><s:textfield name="selectedProgram" value="%{selectedProgram}" label="Program"/></td></tr>
				<tr><td><s:textfield name="selectedBatch" value="%{selectedBatch}" label="Batch"/></td></tr>
				<tr><td><s:textfield name="selectedSemester" value="%{selectedSemester}" label="Semester"/></td></tr>
			</table>
			<br><br>
			<table>
				<tr>
					<th>Sr No</th>
					<th>Student Id</th>
					<th>Student Name</th>
					<th></th>
				</tr>
				
				<s:set var="c" value="1"></s:set>
				<s:iterator var="i" value="StudentId">
					<tr>
						<td><s:property value="#c"/></td>
						<td><s:property value="#i[0].std_id"/></td>
						<td><s:property value="#i[0].std_name"/></td>
						<td><s:checkbox name="selectedStudent" fieldValue="%{#i[0].std_id}" theme="simple"/></td>
						<s:set var="c" value="%{#c + 1}"></s:set>
					</tr>
				</s:iterator>
			</table>
			<s:submit value="confirm Unregisteration"/>
		</s:form>
	</s:else>
</body>
</html>