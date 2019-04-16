<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page import="java.util.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Course in Term Acad</title>
<link rel="stylesheet" type="text/css" href="getTerm.css">
</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>

	<s:if test="Offer.size()==0">
		<h2>No Course Found</h2><br>
	</s:if>
	<s:else>
		<h1>Acad Year : <s:property value="%{selectedAcad}"/>
		Term Name : <s:property value="%{selectedterm}"/></h1>
		<table class="gridtable">
			<tr>
	    		<th>Course Name</th> 
	    		<th>Category</th>
	    		<th>Level</th>
	    		<th>Descipline</th>
	    		<th>Code</th>
	    		<th>Assessment Type</th>
	    		<th>L-T-P-C</th>
	    		<th>Faculty Name</th>
	    		<th></th>
	    		<th></th>
	  		</tr>
	  		<s:iterator var="o" value="Offer">
				<tr>
					<td><s:property value = "#o[2].course_name"/></td>
					<td><s:property value = "#o[2].category"/></td>
					<td><s:property value = "#o[2].c_level"/></td>
					<td><s:property value = "#o[2].descipline"/></td>
					<td><s:property value = "#o[2].c_code"/></td>
					<td><s:property value = "#o[2].accessment_type"/></td>
					<td><s:property value = "#o[2].L+'-'+#o[2].T+'-'+#o[2].P+'-'+#o[2].C"/></td>
					<td><s:property value = "#o[1].f_name" /></td>
					<td>
					<s:url action="editAcadTermCourseForm" var="c_edit_url" escapeAmp="false">
						<s:param name="selectedAcad" value="%{selectedAcad}"/>
						<s:param name="selectedterm" value="%{selectedterm}"/>
						<s:param name="selectedFaculty" value="#o[1].f_id"/>
						<s:param name="selectedOffer" value="#o[0].offer_id"/>
						<s:param name="selectedCourse" value="#o[2].c_code"/>
					</s:url>
					<a class = "buttonize" href='<s:property value = "#c_edit_url"/>'>Edit</a>
					</td>
		    		<td>
		    		<s:url action="deleteAcadTermCourse" var="c_delete_url" escapeAmp="false">
						<s:param name="selectedAcad" value="%{selectedAcad}"/>
						<s:param name="selectedterm" value="%{selectedterm}"/>
						<s:param name="selectedFaculty" value="#o[1].f_id"/>
						<s:param name="selectedCourse" value="#o[2].c_code"/>
						<s:param name="selectedOffer" value="#o[0].offer_id"/>
		    		</s:url>
					<a class = "buttonize" href='<s:property value = "#c_delete_url"/>'>Delete</a>
		    		</td>
	    		</tr>
			</s:iterator>
		</table><br>
	</s:else>
	<s:url action="addAcadTermCourseForm" var="a_course_url" escapeAmp="false">
		<s:param name="selectedAcad" value="%{selectedAcad}"/>
		<s:param name="selectedterm" value="%{selectedterm}"/>
	</s:url>
	<div class = "centralize"><a class = "buttonize" href='<s:property value = "#a_course_url"/>'>Add Course</a></div> 
</body>
</html>