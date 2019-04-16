<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dean Ap</title>
<link href = "getTerm.css" type = "text/css" rel = "stylesheet">
</head>
<body>	
	<jsp:include page="nav.jsp"></jsp:include>
	
	<s:url action="getCourse" var="course_url"/>
	<a href='<s:property value = "#course_url"/>'>Course</a><br><br>
	
	<s:url action="getAcadTermCourse" var="atc_url"/>
	<a href='<s:property value = "#atc_url"/>'>Add Course in Term-Acad</a><br><br>	
	
	<s:url action="Student" var="atc_url"/>
	<a href='<s:property value = "#atc_url"/>'>Student Profile</a><br><br>
	
	<s:url action="Registrar" var="url"></s:url>
	<a href='<s:property value = "#url"/>'>Registration Approval</a><br><br>
	
	<s:url action="RegistrarSchedule" var="url"></s:url>
	<a href='<s:property value = "#url"/>'>Set Registration Schedule</a><br><br>
	
	<s:url action="RegistrarResultAnalysis" var="url"></s:url>
	<a href='<s:property value = "#url"/>'>Result Analysis</a><br><br>	
	
</body>
</html>