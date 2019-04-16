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
	<h2>Filter Result</h2>
	<s:form method="post">
	
		<font size="4">Find Result Course-wise</font><br><br>
		
		<table>
			<tr>
				<td><s:select list="acad" name="selectedAcad" label="Academic Year" listKey="a_year" listValue="a_year"/></td>
				<td><s:select list="term" name="selectedTerm" label="Term" listKey="taid.t_name" listValue="taid.t_name"/></td>
				<td><s:select list="course" name="selectedCourse" label="Course" listKey="c_code" listValue="course_name"/></td>
			</tr>
			<tr><td><s:submit value="Find"  action="RegistrarResultAnalysiscoursewise"/></td></tr>
		</table>
		
		<br><br>
		
		<font size="4">Find Result Student-wise</font><br><br>
		
		<table>
			<tr><td><s:textfield name="selectedSingleStudent" label="Student Id"/></td><tr>
			<tr><td><s:submit value="Find" action="RegistrarResultAnalysisstudente"/></td></tr>
		</table>
		
		<br><br>
		
		<font size="4">Find Result Semester-wise</font><br><br>		
		
		<table>
			<tr>
				<td><s:select list="batch" name="selectedBatch" label="Batch"/></td>
				<td><s:select list="program" name="selectedProgram" label="Program" listKey="p_id" listValue="p_name"/></td>
				<td><s:select list="semesterList" name="selectedSemester" label="Semester"/></td>
			</tr>
			<tr><td><s:submit value="Find" action="RegistrarResultAnalysissemester"/></td></tr>
		</table>
		
		<br><br>
		
	</s:form>
</body>
</html>