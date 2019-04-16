<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result Analysis</title>
</head>
<body>
	<s:form method="post" action="RegistrarResultAnalysis">
		<h4><s:textfield name="selectedAcad" value="%{selectedAcad}" label="Academic Year"/></h4>
		<h4><s:textfield name="selectedTerm" value="%{selectedTerm}" label="Term"/></h4>
		<h4><s:textfield name="selectedCourse" value="%{selectedCourse}" label="Course"/></h4>
		<table>
			<tr>
				<th>Sr No</th>
				<th>Student Id</th>
				<th>Student Name</th>
				<th>Grade</th>
			</tr>
			<s:set var="count" value="1"></s:set>
			<s:iterator var="i" value="StudentId">
				<tr>
					<td><s:property value="#count"/></td>
					<td><s:property value="#i[0].std_id"/></td>
					<td><s:property value="#i[0].std_name"/></td>
					<td><s:property value="#i[1]"/></td>
					<s:set var="count" value="%{#count + 1}"/>
				</tr>
			</s:iterator>
		</table>
		<s:submit value="back"/>
	</s:form>
</body>
</html>