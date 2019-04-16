<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href = "getTerm.css" type = "text/css" rel = "stylesheet">
</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>

	<s:form method="post" action="addTerm">
		<table class="gridtable">
			<tr><td><s:select list="SpecifiedTermList" name="t.taid.t_name" label="Term" headerKey="-1" headerValue="Term"/></td></tr>
			<tr><td><s:textfield key="t.taid.a_year" label="Acad Year" value="%{year}"/></td></tr>
			<tr><td><s:textfield key="t.start_date" label="Start Date"/></td></tr>
			<tr><td><s:textfield key="t.end_date" label="End Date"/></td></tr>
			<tr><td><s:submit class = "submit-button" value="Add"/></td></tr>		
	  	</table>
	</s:form>
</body>
</html>