<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page import="java.util.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href = "getTerm.css" type = "text/css" rel = "stylesheet">
</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>

	<s:form action="addYear">	
		<table class="gridtable">
			<tr><td><s:textfield key="y" label="Year" value="Year"/></td></tr>
			<tr><td><s:submit class = "submit-button" value="Add"></s:submit></td></tr>
		</table>
	</s:form>
	
</body>
</html>