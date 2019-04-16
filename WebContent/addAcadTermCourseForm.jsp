<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Course</title>
<link href = "getTerm.css" type = "text/css" rel = "stylesheet">
</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>
	
	<s:if test="selectedCourse==null">
		<s:form method="post" action="addAcadTermCourseForm">
			<table class = "gridtable">
				<s:textfield key="selectedterm" label="Term Name" value="%{selectedterm}"/><br><br>
				<s:textfield key="selectedAcad" label="Acad Year" value="%{selectedAcad}"/><br><br>
				<s:select list="CourseList" name="selectedCourse" label="Course" listKey="c_code" listValue="course_name" headerKey="-1" headerValue="Courses"/><br><br>
				<s:submit class = "submit-button" value="Select Course"/>
			</table>
		</s:form>	
	</s:if>
	<s:else>
		<s:form method="post" action="addAcadTermCourse">
				<table class="gridtable">
					<tr><td><s:textfield key="selectedterm" label="Term Name" value="%{selectedterm}"/></td></tr>
					<tr><td><s:textfield key="selectedAcad" label="Acad Year" value="%{selectedAcad}"/></td></tr>
					<tr><td><s:textfield key="c.course_name" label="Course Name" value="%{c.course_name}"/></td></tr>
					<tr><td><s:textfield key="c.c_code" label="Code" value="%{c.c_code}"/></td></tr>
					<tr><td><s:textfield key="c.description" label="Description" value="%{c.description}"/></td></tr>
					<tr><td><s:textfield key="c.c_level" label="Level" value="%{c.c_level}"/></td></tr>
					<tr><td><s:textfield key="c.category" label="Category" value="%{c.category}"/></td></tr>
					<tr><td><s:textfield key="c.descipline" label="Discipline" value="%{c.descipline}"/></td></tr>
					<tr><td><s:textfield key="c.accessment_type" label="AssessmentType" value="%{c.accessment_type}"/></td></tr>
					<tr><td><s:textfield key="c.L" label="Lecture" value="%{c.L}"/></td></tr>
					<tr><td><s:textfield key="c.T" label="Tutorial" value="%{c.T}"/></td></tr>
					<tr><td><s:textfield key="c.P" label="Practical" value="%{c.P}"/></td></tr>
					<tr><td><s:textfield key="c.C" label="Credits" value="%{c.C}"/></td></tr>
					<tr><td><s:textfield key="c.url" label="URL" value="%{c.url}"/></td></tr>
					<tr><td><s:select list="Faculty" name="selectedFaculty" label="Faculty" listKey="f_id" listValue="f_name" headerKey="-1" headerValue="Faculty"/></td></tr>
					<tr><td><s:submit class = "submit-button" value="Add Course"/></td></tr>		
	  			</table>
		</s:form>
	</s:else>
</body>
</html>