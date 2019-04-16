<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Batch Master</title>
<link rel="stylesheet" type="text/css" href="getTerm.css">
</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>

<s:form method="post" action="getSlotAcadTermCourseForm">
	<table class = "gridtable">
		<s:select list="AcadYear" name="selectedAcad" listKey="a_year" listValue="a_year" label="Academic Year" headerKey="-1" headerValue="AcadYear"/><br><br>
		<s:select list="Term" name="selectedterm" label="Term" listKey="taid.t_name" listValue="taid.t_name" headerKey="-1" headerValue="Terms"/><br><br>
		<tr><td><s:hidden name="slotMasterclick" value="true"/></td></tr>
		<s:submit class = "submit-button" value="Show-Batch-Master"/><br>
	</table>
</s:form>
</body>
</html>