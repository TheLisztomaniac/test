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
	<s:if test="%{StudentId.size() == 0}">
		<h3>No Registration request found !</h3>
	</s:if>
	<s:else>
		<s:form method="post" action="ConformRegistrar">
			<table>
				<tr><td><s:textfield name="selectedProgram" value="%{selectedProgram}" label="Program"/></td></tr>
				<tr><td><s:textfield name="selectedBatch" value="%{selectedBatch}" label="Batch"/></td></tr>
				<tr><td><s:textfield name="selectedSemester" value="%{selectedSemester}" label="Semester"/></td></tr>
			</table>
			<br><br>
			<table>
				<tr>
					<th>Request No</th>
					<th>Submit Date</th>
					<th>Registration Form</th>
					<th>Student Id</th>
					<th>Student Name</th>
					<th>Remark</th>
					<th></th>
				</tr>
				
				<s:set var="c" value="1"></s:set>
				<s:iterator var="i" value="StudentId">
					<tr>
						<td><s:property value="#c"/></td>
						<td><s:property value="#i[1]"/></td>
						<td>
							<s:url action="RegistrarSeeForm" var="url" escapeAmp="false">
								<s:param name="selectedSemester" value="%{selectedSemester}"/>
								<s:param name="selectedSingleStudent" value="#i[0].std_id"/>
								<s:param name="selectedBatch" value="%{selectedBatch}"/>
								<s:param name="selectedProgram" value="%{selectedProgram}"/>
							</s:url>
							<a href='<s:property value = "#url"/>'>registration form</a>
						</td>
						<td><s:property value="#i[0].std_id"/></td>
						<td><s:property value="#i[0].std_name"/></td>
						<td><s:textfield name="remark" theme="simple"/></td>
						<td><s:checkbox name="selectedStudent" fieldValue="%{#i[0].std_id}" theme="simple"/></td>
						<s:set var="c" value="%{#c + 1}"></s:set>
					</tr>
				</s:iterator>
			</table>
			<s:submit value="confirm registration"/>
		</s:form>
	</s:else>
</body>
</html>