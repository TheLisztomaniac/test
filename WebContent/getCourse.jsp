<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Course List</title>
<link rel="stylesheet" type="text/css" href="getTerm.css">
</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>
	
	<s:if test="CourseList.size()==0">
		<h2>No Course Found</h2><br>
	</s:if>
	<s:else>
		<table class="gridtable">
			<tr>
	    		<th>Course Name</th> 
	    		<th>Category</th>
	    		<th>Level</th>
	    		<th>Descipline</th>
	    		<th>Code</th>
	    		<th>Assessment Type</th>
	    		<th>L-T-P-C</th>
	    		<th></th>
	    		<th></th>
	  		</tr>
	  		<s:iterator var="c" value="CourseList">
				<tr>
					<td><s:property value = "#c.course_name"/></td>
					<td><s:property value = "#c.category"/></td>
					<td><s:property value = "#c.c_level"/></td>
					<td><s:property value = "#c.descipline"/></td>
					<td><s:property value = "#c.c_code"/></td>
					<td><s:property value = "#c.accessment_type"/></td>
					<td><s:property value = "#c.L+'-'+#c.T+'-'+#c.P+'-'+#c.C"/></td>
					<td>
					<s:url action="editCourseForm" var="course_edit_url">
						<s:param name="CourseCode" value="#c.c_code"/>
					</s:url>
					<a class = "buttonize" href='<s:property value = "#course_edit_url"/>'>Edit</a>
					</td>
		    		<td>
		    		<s:url action="deleteCourse" var="course_delete_url">
		    			<s:param name="CourseCode" value="#c.c_code"/>
		    		</s:url>
					<a class = "buttonize" href='<s:property value = "#course_delete_url"/>'>Delete</a>
		    		</td>
	    		</tr>
			</s:iterator>
		</table><br>
	</s:else>
	<s:url action="addCourseForm" var="add_course_url"></s:url>
	<div class = "centralize"><a class = "buttonize" href='<s:property value = "#add_course_url"/>'>Add Course</a></div>
</body>
</html>