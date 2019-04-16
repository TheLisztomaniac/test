<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error</title>
</head>
<body>
	<h3>Oops ! Registration time period is closed , please contact registrar or wait till Add/Drop period</h3>
	<s:form method="post" action="StudentErrorHandel">
		<s:submit value="Ok"/>
	</s:form>
</body>
</html>