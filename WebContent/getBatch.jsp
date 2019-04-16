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
			<th>Batch_Name</th>
			<th>Term</th>
			<th></th>
			<th>Student_file</th>
		</tr>
		
		<s:iterator var="BL" value="BatchList">
		<tr>
			<td><s:property value="#BL.pbid.batch_name"/></td>
			<td><s:property value="#BL.taid.t_name"/></td>
			<td><s:property value="#BL.taid.a_year"/></td>
			<td>
			<s:url action="fileDownloadBatch" var="download_url" escapeAmp="false">
			<s:param name="ProgramId" value="#BL.pbid.p_id"/>
			<s:param name="batch_name" value="#BL.pbid.batch_name"/>
			</s:url>
			<a class = "buttonize" href='<s:property value = "#download_url"/>' target="_blank"> Download student log</a>
			</td>
		</tr>	
		</s:iterator>
	</table><br>
<s:url action="addBatchForm" var="add_batch_url" escapeAmp="false">
	<s:param name="ProgramId" value="%{ProgramId}"/>
</s:url>
<div class = "centralize"><a class = "buttonize" href='<s:property value="#add_batch_url"/>'>Add Batch</a></div>
</body>
</html>