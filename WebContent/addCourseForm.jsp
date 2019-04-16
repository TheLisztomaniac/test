<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Course</title>
<link rel="stylesheet" type="text/css" href="getTerm.css">
</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>

	<s:form method="post" action="addCourse">
		<table class="gridtable">
			<tr><td><s:textfield key="c.course_name" label="Course Name"/></td></tr>
			<tr><td><s:textfield key="c.c_code" label="Code"/></td></tr>
			<tr><td><s:textfield key="c.description" label="Description"/></td></tr>
			<tr><td><s:select list="Level" name="c.c_level" label="Level" headerKey="-1" headerValue="Level"></s:select></td></tr>
			<tr><td><s:select list="Category" name="c.category" label="Category" headerKey="-1" headerValue="Category"/></td></tr>
			<tr><td><s:select list="Discipline" name="c.descipline" label="Discipline" headerKey="-1" headerValue="Discipline"/></td></tr>
			<tr><td><s:select list="AssessmentType" name="c.accessment_type" label="AssessmentType" headerKey="-1" headerValue="AssessmentType"/></td></tr>
			<tr><td><s:textfield key="c.L" label="Lecture"/></td></tr>
			<tr><td><s:textfield key="c.T" label="Tutorial"/></td></tr>
			<tr><td><s:textfield key="c.P" label="Practical"/></td></tr>
			<tr><td><s:textfield key="c.C" label="Credits"/></td></tr>
			<tr><td><s:textfield key="c.url" label="URL"/></td></tr>
			<tr><td><s:select list="CourseList" multiple="true" name="PreCourseList" label="Pre Requisites" listKey="c_code" listValue="course_name" headerKey="-1" headerValue="Courses"/></td></tr>
			<tr><td></td><td><s:submit class = "submit-button" value="Add Course"/></td></tr>		
	  	</table>
	</s:form>
</body>
</html>