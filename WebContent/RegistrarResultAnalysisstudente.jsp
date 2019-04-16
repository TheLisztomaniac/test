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
	<s:form>
		<s:iterator var="i" value="semesterList">
			<h4>Semester : <s:property value="#i"/></h4>
			<table>
				<tr>
					<th>Sr No</th>
					<th>Course Name</th>
					<th>Grade</th>
				</tr>
				<s:set var="count" value="1"/>
				<s:iterator var="j" value="%{StudentSem[#i]}">
					<tr>
						<td><s:property value="#count"/></td>
						<td><s:property value="#j[2].course_name"/></td>
						<td><s:property value="#j[1].grade"/></td>
						<s:set var="count" value="%{#count + 1}"></s:set>
					</tr>
				</s:iterator>
			</table>
		</s:iterator>
	</s:form>
</body>
</html>