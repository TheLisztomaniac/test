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

	<s:form method="post" action="addBatch" enctype="multipart/form-data">
		<table class="form">
			<tr><td><s:textfield label="Program Name" value="%{p.p_name}"/></td></tr>
			<s:hidden name="ProgramId" value="%{p.p_id}"></s:hidden>
			<tr><td><s:textfield key="batch_name" label="batch_name"/></td></tr>
			<tr><td><s:textfield key="taid.a_year" label="a_year"/></td></tr>
			<tr><td><s:textfield key="taid.t_name" label="t_name"/></td></tr>
			<tr><td><s:file name="student_file" label="select to upload a student_list_file" size="40"/></td></tr>
			<tr><td><s:submit class = "submit-button" value="Add"/></td></tr>		
	  	</table>
	</s:form>
</body>
</html>