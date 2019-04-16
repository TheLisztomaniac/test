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

	<s:form action = "getTerm">
		<table class="gridtable">
			<tr><td><s:select list="AcadYearList" name="year" label="acad_year" listKey="a_year" listValue="a_year" headerKey="-1" headerValue="acad_year"></s:select></td></tr>
			<tr><td><s:submit class = "submit-button" value="Terms"/></td></tr>		
	  	</table>
	</s:form>
</body>
</html>