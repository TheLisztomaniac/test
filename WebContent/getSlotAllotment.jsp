<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Slot - Allotment</title>
<link rel="stylesheet" type="text/css" href="getTerm.css">
</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>
	
<s:form method="post" action="getSlotAllotmentQuery">
	<table class = "gridtable">
		<s:select list="AcadYear" name="selectedAcad" listKey="a_year" listValue="a_year" label="Academic Year*" headerKey="-1" headerValue="0"/><br><br>
		<s:select list="Term" name="selectedTerm" label="Term*" listKey="taid.t_name" listValue="taid.t_name" headerKey="-1" headerValue="0"/><br><br>
		<s:select list="Program" name="selectedProgram" listKey="p_id" listValue="p_name" label="Program" headerKey="-1" headerValue="0"/><br><br>
		<s:select list="Slot" name="selectedSlot" label="Slot" listKey="slot_no" listValue="slot_name" headerKey="-1" headerValue="0"/><br><br>
		<s:submit class = "submit-button" value="Filter Query"/><br><br>
	</table>
</s:form>
</body>
</html>