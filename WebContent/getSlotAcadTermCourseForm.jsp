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

	<h1>Acad Year : <s:property value="%{selectedAcad}"/>
	Term Name : <s:property value="%{selectedterm}"/></h1>
	<s:if test="Offer.size()!=0">
		<s:set var="count" value="1"/>	
		
	  		<s:iterator var="o" value="Offer">
	  			<s:form method="post" action="getSlotAcadTermCourseForm">
	  				<table class="gridtable">
		  				<tr><td><s:textfield value = "%{#count}" label="Course No"/></td></tr>
						<tr><td><s:textfield value = "%{#o[2].course_name}" label="Course Name"/></td></tr>
						<tr><td><s:textfield value = "%{#o[2].L+'-'+#o[2].T+'-'+#o[2].P+'-'+#o[2].C}" label="L-T-P-C"/></td></tr>
						<tr><td><s:textfield value = "%{#o[1].f_name}" label="Faculty"/></td></tr>
						<tr><td><s:hidden name="selectedAcad" value="%{selectedAcad}"/></td></tr>
						<tr><td><s:hidden name="selectedterm" value="%{selectedterm}"/></td></tr>
						<tr><td><s:textfield name="selectedOffer" value="%{#o[0].offer_id}" label="Offere Id"/></td></tr>
						<tr><td><s:hidden name="click" value="true"/></td></tr>
						<tr><td><s:select label="Program" list="Program" multiple="true" name="selectedProgram" listKey="p_id" listValue="p_name" headerKey="-1" /></td></tr>
						<tr><td><s:select label="Batch" list="Batch" multiple="true" name="selectedBatch" listKey="pbid.batch_name" listValue="pbid.batch_name" headerKey="-1"/></td></tr>
						<tr><td><s:select label="Type" list="Type" name="selectedType" headerKey="-1" headerValue="Type"/></td></tr>
						<tr><td><s:select label="Slot" list="Slot" name="selectedSlot" listKey="slot_no" listValue="slot_name" headerKey="-1" headerValue="Slot"/></td></tr>
						<tr><td><s:submit class = "submit-button" value="Save"/></td></tr>
						<s:set var="count" value="%{#count+1}"/>
					</table><br>
	  			</s:form>
			</s:iterator>
		<br><br>
	</s:if>
	<s:else>
		<s:url action="getSlotAcadTermCourseForm" var="edit_url" escapeAmp="false">
						<s:param name="selectedAcad" value="%{selectedAcad}"/>
						<s:param name="selectedterm" value="%{selectedterm}"/>
						<s:param name="click" value="true"/>
		</s:url>
		<div class = "centralize"><a class = "buttonize" href='<s:property value = "#edit_url"/>'>Exit</a></div>
	</s:else>
</body>
</html>