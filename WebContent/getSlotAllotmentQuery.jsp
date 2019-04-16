<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Slot Allotment</title>
<link rel="stylesheet" type="text/css" href="getTerm.css">

</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>

		<s:iterator var="i" value="QueryResult">
			<div class = "slot_no">
				<h3>Slot : <s:property value="#i[3].slot_name"/></h3><br>
			</div>
			<div class = "slot_content">
			<s:iterator var="j" value="QueryResult">
				<s:if test="%{#i[3].slot_no == #j[3].slot_no}"><br>
					<div class = "program">
						<h4>Program : <s:property value="#j[2].p_name"/></h4>
					</div>
					<div class = "course">
					<s:iterator var="k" value="QueryResult">
						<s:if test="%{#i[3].slot_no == #k[3].slot_no && #j[2].p_id == #k[2].p_id}">
							Course : <s:property value="#k[4].course_name"/><br>
						</s:if>
					</s:iterator>
					</div>
				</s:if>
				<br><br>
			</s:iterator>
			</div>
		</s:iterator>
</body>
</html>