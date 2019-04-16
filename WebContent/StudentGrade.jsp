<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Grade</title>
</head>
<body>
	<h3>Student Id : <s:property value="%{StudentId}"/></h3>
	<h3>Semester : <s:property value="%{sem}"/></h3>
	
	<table>
		<tr>
			<th>Sr No</th>
			<th>Course Name</th>
			<th>Code</th>
			<th>Credits</th>
			<th>Course Type</th>
			<th>Grade</th>
			<th>Grade Point</th>
		</tr>
		
		<s:set var="current_credit_register" value="0"/>
		<s:set var="current_grade_point" value="0"></s:set>
		<s:set var="count" value="1"></s:set>
		
		<s:iterator var="c" value="ResultInTermAcad">
			<tr>
				<s:set var="credit" value="#c[1].L+#c[1].T+#c[1].P+#c[1].C"></s:set>
				<td><s:property value="#count"/></td>
				<td><s:property value="#c[1].course_name"/></td>
				<td><s:property value="#c[1].c_code"/></td>
				<td><s:property value="#credit+'('+#c[1].L+'-'+#c[1].T+'-'+#c[1].P+'-'+#c[1].C+')'"/></td>
				<td><s:property value="#c[2].c_type"/></td>
				<td><s:property value="#c[0].grade"/></td>
				<td><s:property value="%{#credit*hm.get(#c[0].grade)}"/></td>
				<s:set var="current_credit_register" value="%{#current_credit_register + #credit}"/>
				<s:set var="current_grade_point" value="%{#current_grade_point + (#credit*hm.get(#c[0].grade))}"/>
				<s:set var="count" value="%{#count + 1}"/>
			</tr>
		</s:iterator>
	</table><br>
	
	<s:set var="i" value="result"/>
	
	<table>
		<tr>
			<th></th>
			<th>Credit Registered</th>
			<th>Credit Earned</th>
			<th>Grade Point Earned</th>
			<th>SPI / CPI</th>
		</tr>
		
		<tr>
			<td>Current</td>
			<td><s:property value="#current_credit_register"/></td>
			<td><s:property value="#current_credit_register"/></td>
			<td><s:property value="#current_grade_point"/></td>
			<td><s:property value="(#current_grade_point / #current_credit_register)"/></td>
		</tr>
		
	<s:if test="%{sem==1}">
		<tr>
			<td>Cummulative</td>
			<td><s:property value="#current_credit_register"/></td>
			<td><s:property value="#current_credit_register"/></td>
			<td><s:property value="#current_grade_point"/></td>
			<td><s:property value="(#current_grade_point / #current_credit_register)"/></td>
		</tr>
		<s:url action="UpdateStudentFindResult" var="u_url" escapeAmp="false">
			
			<s:param name="sem" value="%{sem}"/>
			<s:param name="StudentId" value="%{StudentId}"/>
			<s:param name="current_credit_register" value="#current_credit_register" />
			<s:param name="current_credit_earn" value="#current_credit_register" />
			<s:param name="current_grade_point" value="#current_grade_point" />
			<s:param name="cpi" value="(#current_grade_point / #current_credit_register)" />
			<s:param name="till_credit_register" value="#current_credit_register" />
			<s:param name="till_credit_earn" value="#current_credit_register" />
			<s:param name="till_grade_point" value="#current_grade_point" />
			<s:param name="spi" value="(#current_grade_point / #current_credit_register)" />
				
		</s:url>
		<tr><td><a href='<s:property value="#u_url"/>'>close</a></td></tr>
	</s:if>
	<s:else>
	
		<s:if test="%{sem==2}">
			<s:set var="pre_till_credit" value="#i.s1_till_credit_register"/>
			<s:set var="pre_till_earn" value="#i.s1_till_credit_achieved"/>
			<s:set var="pre_till_grade_point" value="#i.s1_till_grade_point"/>
		</s:if>
		<s:elseif test="%{sem==3}">
			<s:set var="pre_till_credit" value="#i.s2_till_credit_register"/>
			<s:set var="pre_till_earn" value="#i.s2_till_credit_achieved"/>
			<s:set var="pre_till_grade_point" value="#i.s2_till_grade_point"/>
		</s:elseif>
		<s:elseif test="%{sem==4}">
			<s:set var="pre_till_credit" value="#i.s3_till_credit_register"/>
			<s:set var="pre_till_earn" value="#i.s3_till_credit_achieved"/>
			<s:set var="pre_till_grade_point" value="#i.s3_till_grade_point"/>
		</s:elseif>
		<s:elseif test="%{sem==5}">
			<s:set var="pre_till_credit" value="#i.s4_till_credit_register"/>
			<s:set var="pre_till_earn" value="#i.s4_till_credit_achieved"/>
			<s:set var="pre_till_grade_point" value="#i.s4_till_grade_point"/>
		</s:elseif>
		<s:elseif test="%{sem==6}">
			<s:set var="pre_till_credit" value="#i.s5_till_credit_register"/>
			<s:set var="pre_till_earn" value="#i.s5_till_credit_achieved"/>
			<s:set var="pre_till_grade_point" value="#i.s5_till_grade_point"/>
		</s:elseif>
		<s:elseif test="%{sem==7}">
			<s:set var="pre_till_credit" value="#i.s6_till_credit_register"/>
			<s:set var="pre_till_earn" value="#i.s6_till_credit_achieved"/>
			<s:set var="pre_till_grade_point" value="#i.s6_till_grade_point"/>
		</s:elseif>
		<s:elseif test="%{sem==8}">
			<s:set var="pre_till_credit" value="#i.s7_till_credit_register"/>
			<s:set var="pre_till_earn" value="#i.s7_till_credit_achieved"/>
			<s:set var="pre_till_grade_point" value="#i.s7_till_grade_point"/>
		</s:elseif>
	
		<tr>
			<td>Cummulative</td>
			<td><s:property value="#pre_till_credit + #current_credit_register"/></td>
			<td><s:property value="#pre_till_earn + #current_credit_register"/></td>
			<td><s:property value="#pre_till_grade_point + #current_grade_point"/></td>
			<td><s:property value="(#pre_till_grade_point + #current_grade_point)/(#pre_till_credit + #current_credit_register)"/></td>
		</tr>
		
		<s:url action="UpdateStudentFindResult" var="u_url" escapeAmp="false">
			
			<s:param name="sem" value="%{sem}"/>
			<s:param name="StudentId" value="%{StudentId}"/>
			<s:param name="current_credit_register" value="#current_credit_register" />
			<s:param name="current_credit_earn" value="#current_credit_register" />
			<s:param name="current_grade_point" value="#current_grade_point" />
			<s:param name="cpi" value="(#current_grade_point / #current_credit_register)" />
			<s:param name="till_credit_register" value="#pre_till_credit + #current_credit_register" />
			<s:param name="till_credit_earn" value="#pre_till_earn + #current_credit_register" />
			<s:param name="till_grade_point" value="#pre_till_grade_point + #current_grade_point" />
			<s:param name="spi" value="(#pre_till_grade_point + #current_grade_point)/(#pre_till_credit + #current_credit_register)" />	
		</s:url>
		<tr><td><a href='<s:property value="#u_url"/>'>close</a></td></tr>		
	</s:else>
	</table>
</body>
</html>