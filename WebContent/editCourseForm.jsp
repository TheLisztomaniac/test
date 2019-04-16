<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Course</title>
<link rel="stylesheet" type="text/css" href="getTerm.css">
</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>
	
	<s:form method="post" action="editCourse">
		<table class="gridtable">
			<tr><td><s:textfield key="c.course_name" label="Course Name" value="%{c.course_name}"/></td></tr>
			<tr><td><s:textfield key="c.c_code" label="Code" value="%{c.c_code}"/></td></tr>
			<tr><td><s:textfield key="c.description" label="Description" value="%{c.description}"/></td></tr>
			<tr><td><s:select list="Level" name="c.c_level" label="Level" headerKey="-1" headerValue="Level"></s:select></td></tr>
			<tr><td><s:select list="Category" name="c.category" label="Category" headerKey="-1" headerValue="Category"/></td></tr>
			<tr><td><s:select list="Discipline" name="c.descipline" label="Discipline" headerKey="-1" headerValue="Discipline"/></td></tr>
			<tr><td><s:select list="AssessmentType" name="c.accessment_type" label="AssessmentType" headerKey="-1" headerValue="AssessmentType"/></td></tr>
			<tr><td><s:textfield key="c.L" label="Lecture" value="%{c.L}"/></td></tr>
			<tr><td><s:textfield key="c.T" label="Tutorial" value="%{c.T}"/></td></tr>
			<tr><td><s:textfield key="c.P" label="Practical" value="%{c.P}"/></td></tr>
			<tr><td><s:textfield key="c.C" label="Credits" value="%{c.C}"/></td></tr>
			<tr><td><s:textfield key="c.url" label="URL" value="%{c.url}"/></td></tr>
			<tr><td><s:select list="CourseList" multiple="true" name="PreCourseList" label="Pre Requisites" listKey="c_code" listValue="course_name" headerKey="-1" headerValue="Courses"/></td></tr>
			<tr><td></td><td><s:submit class = "submit-button" value="edit Course"/></td></tr>		
	  	</table>
	</s:form>
</body>
</html>