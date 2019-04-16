<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Program List</title>
<link rel="stylesheet" type="text/css" href="getTerm.css">
</head>
<body>
	<jsp:include page="nav.jsp"></jsp:include>

	<s:if test="programList.size()==0">
		<h2>No Program Found</h2><br>
	</s:if>
	<s:else>
		<table class="gridtable" >
			<tr>
	    		<th>Serial No</th>
	    		<th>Program Name</th> 
	    		<th>Code</th>
	    		<th>Description</th>
	    		<th>Duration</th>
	    		<th>Unit</th>
	    		<th></th>
	    		<th></th>
	    		<th></th>
	  		</tr>
	  		<s:iterator var="p" value="programList">
				<tr>
					<td><s:property value = "#p.p_id"/></td>
					<td><s:property value = "#p.p_name"/></td>
					<td><s:property value = "#p.p_code"/></td>
					<td><s:property value = "#p.discription"/></td>
					<td><s:property value = "#p.duration"/></td>
					<td><s:property value = "#p.duration_unit"/></td>
					<td>
					<s:url action="editProgramForm" var="program_edit_url">
						<s:param name="ProgramId" value="#p.p_id"/>
					</s:url>
					<a class = "buttonize" href='<s:property value = "#program_edit_url"/>'>Edit</a>
					</td>
		    		<td>
		    		<s:url action="deleteProgram" var="program_delete_url">
		    			<s:param name="ProgramId" value="#p.p_id"/>
		    		</s:url>
					<a class = "buttonize" href='<s:property value = "#program_delete_url"/>'>Delete</a>
		    		</td>
		    		<td>
		    		<s:url action="getBatch" var="get_batch_url">
		    			<s:param name="ProgramId" value="#p.p_id"/>
		    		</s:url>
					<a class = "buttonize" href='<s:property value = "#get_batch_url"/>'>Batches</a>
		    		</td>
	    		</tr>
			</s:iterator>
		</table><br>
	</s:else>
	<s:url action="addProgramForm" var="add_program_url"></s:url>
	<div class = "centralize"><a class = "buttonize" href='<s:property value = "#add_program_url"/>'>Add Program</a></div>
</body>
</html>