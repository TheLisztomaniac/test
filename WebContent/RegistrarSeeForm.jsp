<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Registration Form</title>
</head>
<body>

	<s:form method="post" action="getRegistrarForm">
		<h3><s:textfield name="selectedSingleStudent" value="%{selectedSingleStudent}" label="Student Id"/></h3>
		<h3><s:textfield name="selectedSemester" value="%{selectedSemester}" label="Semester"/></h3>
		
		<table>
			<tr>
				<th>Course Name</th>
				<th>Code</th>
				<th>Credits</th>
				<th>Course Type</th>
				<th>Select for unregister</th>
			</tr>
			
			<s:iterator var="c" value="ResultInTermAcad">
				<tr>
					<s:set var="credit" value="#c[1].L+#c[1].T+#c[1].P+#c[1].C"></s:set>
					<td><s:property value="#c[1].course_name"/></td>
					<td><s:property value="#c[1].c_code"/></td>
					<td><s:property value="#credit+'('+#c[1].L+'-'+#c[1].T+'-'+#c[1].P+'-'+#c[1].C+')'"/></td>
					<td><s:property value="#c[2].c_type"/></td>
					<td><s:checkbox name="courseUndo" fieldValue="%{#c[1].c_code}" theme="simple"/></td>
				</tr>
			</s:iterator>
		</table>
		<s:hidden name="selectedProgram" value="%{selectedProgram}"/>
		<s:hidden name="selectedBatch" value="%{selectedBatch}"/>
		<s:hidden name="check" value="1"/>
		<s:submit value="Save And Back"/>
	</s:form>
	
</body>
</html>