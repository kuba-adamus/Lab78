<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Employee Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Add a Employee
</h1>

<c:url var="addAction" value="/employee/add" ></c:url>

<form:form action="${addAction}" commandName="employee">
<table>
	<c:if test="${!empty employee.firstName}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="firstName">
				<spring:message text="FirstName"/>
			</form:label>
		</td>
		<td>
			<form:input path="firstName" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="address">
				<spring:message text="Address"/>
			</form:label>
		</td>
		<td>
			<form:input path="address" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty employee.firstName}">
				<input type="submit"
					value="<spring:message text="Edit Employee"/>" />
			</c:if>
			<c:if test="${empty employee.firstName}">
				<input type="submit"
					value="<spring:message text="Add Employee"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Employee List</h3>
<c:if test="${!empty listEmployees}">
	<table class="tg">
	<tr>
		<th width="80">Person ID</th>
		<th width="120">Employee Firstname</th>
		<th width="120">Employee Lastname</th>
		<th width="120">Address</th>
		<th width="120">Birth date</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listEmployees}" var="employee">
		<tr>
			<td>${employee.id}</td>
			<td>${employee.firstName}</td>
			<td>${employee.lastName}</td>
			<td>${employee.address}</td>
			<td>${employee.birth}</td>
			<td><a href="<c:url value='/edit/${employee.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${employee.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
