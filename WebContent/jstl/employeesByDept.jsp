<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employees By Dept</title>
</head>
<body>
	<h2>Employees By Dept</h2>
	<form action="employeesByDept.jsp">
		Department Number : <input type="text" name="dept"
			value="${param.dept}" /> <input type="submit" value="Employees" />
	</form>

	<%
		String deptid = request.getParameter("dept");
		if (deptid == null || deptid.equals(""))
			return; // terminate JSP
	%>


	<sql:setDataSource var="oracle"
		driver="oracle.jdbc.driver.OracleDriver"
		url="jdbc:oracle:thin:@localhost:1521:XE" user="hr" password="hr" />

	<sql:query var="result" dataSource="${oracle}">
        select * from employees where department_id = ?
        <sql:param value="${param.dept}"></sql:param>
	</sql:query>

    <p/>

	<table style="width: 100%" border="1">
		<tr>
			<th>Name</th>
			<th>Job</th>
			<th>Salary</th>
		</tr>

		<c:forEach var="row" items="${result.rows}">
			<tr>
				<td>${row.first_name}</td>
				<td>${row.job_id}</td>
				<td>${row.salary}</td>
		</c:forEach>


	</table>

</body>
</html>