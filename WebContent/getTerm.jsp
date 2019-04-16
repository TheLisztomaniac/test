<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="getTerm.css">
</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>

	<s:if test="TermList.size()==0">
		<h2>No terms found</h2>
	</s:if>
	<s:else>
		<h1>Acad Year : <s:property value="year"/></h1><br><br>
		<table class="gridtable">
			<tr>
				<th>Term_name</th>
				<th>Start_date</th>
				<th>End_date</th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
			<s:iterator var="TL" value="TermList">
			<tr>
				<td><s:property value = "#TL.taid.t_name"/></td>
				<td><s:property value = "#TL.start_date"/></td>
				<td><s:property value = "#TL.end_date"/></td>
				<td>
				<s:url action="editTermForm" var="term_edit_url" escapeAmp="false">
					<s:param name="taid.a_year" value="#TL.taid.a_year"/>
					<s:param name="taid.t_name" value="#TL.taid.t_name"/>
				</s:url>
				<a class = "buttonize" href='<s:property value="#term_edit_url"/>'>Edit</a>
				</td>
				<td>
				<s:url action="deleteTerm" var="term_delete_url" escapeAmp="false">
					<s:param name="taid.t_name" value="#TL.taid.t_name"/>
					<s:param name="taid.a_year" value="#TL.taid.a_year"/>
					
				</s:url>
				<a class = "buttonize" href='<s:property value="#term_delete_url"/>'>Delete</a>
				</td>
				<td>
				<s:url action="#" var="term_Courses_url"></s:url>
				<a class = "buttonize" href='<s:property value="#term_Courses_url"/>'>Term Courses</a>
				</td>
			</tr>
			</s:iterator>
		</table><br>
	</s:else>
	<s:url action="addTermForm" var="term_Courses_url">
		<s:param name="year" value="%{year}"></s:param>
	</s:url>
	<div class = "centralize"><a class = "buttonize" href='<s:property value="#term_Courses_url"/>'>Add Term</a></div>
</body>
</html>