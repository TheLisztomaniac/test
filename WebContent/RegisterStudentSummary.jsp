<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
	
	<h3>Registration Summary</h3>
	
	<s:form method="post" action="RegisterStudent">
		<h3><s:textfield name="StudentId" value="%{StudentId}" label="Student Id"/></h3>
		<h3><s:textfield name="sem" value="%{sem}" label="Semester"/></h3>
		<table>
			<tr>
				<th>Slot</th>
				<th>Course Name</th>
				<th>Code</th>
				<th>Credits</th>
				<th>Course Type</th>
			</tr>
			
			<s:set var="c_sum" value="0"></s:set>
			<s:iterator var="c" value="ResultInTermAcad">
				<tr>
					<s:set var="credit" value="#c[4].L+#c[4].T+#c[4].P+#c[4].C"></s:set>
					<td><s:property value="#c[0].osid.slot_no"/></td>
					<td><s:property value="#c[4].course_name"/></td>
					<td><s:property value="#c[4].c_code"/></td>
					<td><s:property value="#credit+'('+#c[4].L+'-'+#c[4].T+'-'+#c[4].P+'-'+#c[4].C+')'"/></td>
					<td><s:property value="#c[0].c_type"/></td>
					<s:set var="c_sum" value="%{#c_sum + #credit}"></s:set>
					<s:hidden name="selectedCourse" value="%{#c[4].c_code}"/>
				</tr>
			</s:iterator>
		</table><br>
		
		<s:set var="req" value="requirment"/>
		<s:set var="s" value="0"/>
		<s:set var="p" value="0"/>
		
		<s:if test="%{sem==1}">
			<s:set var="s" value="#req.s1_max_credit"/>
			<s:set var="p" value="0"/>
		</s:if>
		<s:elseif test="%{sem==2}">
			<s:set var="s" value="#req.s2_max_credit"/>
			<s:set var="p" value="%{result.s1_till_credit_achieved}"/>
		</s:elseif>
		<s:elseif test="%{sem==3}">
			<s:set var="s" value="#req.s3_max_credit"/>
			<s:set var="p" value="%{result.s2_till_credit_achieved}"/>
		</s:elseif>
		<s:elseif test="%{sem==4}">
			<s:set var="s" value="#req.s4_max_credit"/>
			<s:set var="p" value="%{result.s3_till_credit_achieved}"/>
		</s:elseif>
		<s:elseif test="%{sem==5}">
			<s:set var="s" value="#req.s5_max_credit"/>
			<s:set var="p" value="%{result.s4_till_credit_achieved}"/>
		</s:elseif>
		<s:elseif test="%{sem==6}">
			<s:set var="s" value="#req.s6_max_credit"/>
			<s:set var="p" value="%{result.s5_till_credit_achieved}"/>
		</s:elseif>
		<s:elseif test="%{sem==7}">
			<s:set var="s" value="#req.s7_max_credit"/>
			<s:set var="p" value="%{result.s6_till_credit_achieved}"/>
		</s:elseif>
		<s:elseif test="%{sem==8}">
			<s:set var="s" value="#req.s8_max_credit"/>
			<s:set var="p" value="%{result.s7_till_credit_achieved}"/>
		</s:elseif>
		
		<table>
			<tr><td>Number of course</td><td><s:property value="%{ResultInTermAcad.size()+'/'+ availCourse}"/></td></tr>
			<tr><td>Credit Registered</td><td><s:property value="%{#c_sum+'/'+ #s}"/></td></tr>
			<tr><td>Credit Registered (Overall)</td><td><s:property value="%{(#p + #c_sum)+'/'+#req.total_min_credit}"/></td></tr>
		</table>
		<br><br>
		
		<table>
			<tr>
				<th></th>
				<th>Current</th>
				<th>All (Including current)</th>
			</tr>
			
			<tr>
				<td>Group Elective</td>
				<td><s:property value="%{current[0]}"/></td>
				<td><s:property value="%{all[0]+'/'+#req.min_group_elective}"/></td>
			</tr>
			
			<tr>
				<td>Technical Elective</td>
				<td><s:property value="%{current[1]}"/></td>
				<td><s:property value="%{all[1]+'/'+#req.min_technical_elective}"/></td>
			</tr>
			
			<tr>
				<td>Science Elective</td>
				<td><s:property value="%{current[2]}"/></td>
				<td><s:property value="%{all[2]+'/'+#req.min_science_elective}"/></td>
			</tr>
			
			<tr>
				<td>Open Elective</td>
				<td><s:property value="%{current[3]}"/></td>
				<td><s:property value="%{all[3]+'/'+#req.min_other_elective}"/></td>
			</tr>
			
		</table>
		
		<br><br>
		<s:select list="Authority" name="selectedAuthority" label="Course Authority" headerKey="-1" headerValue="Select Authority"/><br><br>
		<s:textfield label="Remark" name="remark"/><br><br>
		
		<s:hidden name="adddrop" value="%{adddrop}"/>
		<s:submit value="Confirm Register"/>
	</s:form>
</body>
</html>