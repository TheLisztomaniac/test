<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href = "getTerm.css" type = "text/css" rel = "stylesheet">
</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>

<table class="gridtable">
	<tr>
		<th>Year</th>
		<th></th>
	</tr>
	</tr>
	<s:iterator var="AYL" value="AcadYearList">
	<tr>
		<td><s:property value = "#AYL.a_year"/></td>
		<td>
			<s:url action="deleteYear" var="year_delete_url" escapeAmp="false">
				<s:param name="y" value="#AYL.a_year"/>
			</s:url>
			<a class = "buttonize" href='<s:property value="#year_delete_url"/>'>Delete</a>
		</td>
	</tr>
	</s:iterator>
</table><br>
<s:url action="addYearForm" var="add_year_url" escapeAmp="false"></s:url>
<div class = "centralize"><a class = "buttonize" href='<s:property value="#add_year_url"/>'>Add Year</a></div>
</body>
</html>