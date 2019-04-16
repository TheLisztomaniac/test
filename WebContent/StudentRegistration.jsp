<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registration</title>
</head>
<body>

	<s:form method="post" action="RegisterStudentSummary">
		<h3><s:textfield name="StudentId" value="%{StudentId}" label="Student Id"/></h3>
		<h3><s:textfield name="selectedSemester" value="%{selectedSemester}" label="Semester"/></h3>
		<table>
			<tr>
				<th>Slot</th>
	    		<th>Course Name</th> 
	    		<th>Code</th>
	    		<th>Credits</th>
	    		<th>Type</th>
	    		<th>Select</th>
		  	</tr>
		  	
		  	<s:set var="count" value="0"/>
		  	<s:iterator var="i" value="slot">
		  		<tr><td><s:property value="#i.slot_no"/></td></tr>
		  		<s:set var="bool" value="0"/>
		  		<s:iterator var="c" value="%{courseSlot[#i.slot_no]}">
		  		
		  			<s:if test="%{#bool==0}">
		  				<s:set var="bool" value="1"/>
		  				<s:set var="count" value="%{#count+1}"/>
		  			</s:if>
		  		
		  			<tr>
		  				<td></td>
						<td><s:property value="#c[4].course_name"/></td>
						<td><s:property value="#c[4].c_code"/></td>
						<td><s:property value="#c[4].L+#c[4].T+#c[4].P+#c[4].C+'('+#c[4].L+'-'+#c[4].T+'-'+#c[4].P+'-'+#c[4].C+')'"/></td>
						<td><s:property value="#c[0].c_type"/></td>
						<td><s:checkbox name="selectedCourse" fieldValue="%{#c[4].c_code}" theme="simple"/></td>
					</tr>
		  		</s:iterator>	
		  	</s:iterator>
		</table><br>
		<s:hidden name="availCourse" value="%{#count}"/>
		<s:hidden name="adddrop" value="%{adddrop}"/>
		<s:submit value="See Summary"/>
	</s:form>	
</body>
</html>