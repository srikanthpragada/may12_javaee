<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="oracle.jdbc.rowset.*" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employees By Dept</title>
</head>
<body>
	<h2>Employees By Dept</h2>
	<form action="employeesByDept.jsp">
		Department Number : <input type="text" name="dept"  value="${param.dept}"/> <input
			type="submit" value="Employees" />
	</form>

	<%
		String deptid = request.getParameter("dept");
		if (deptid == null || deptid.equals(""))
			return; // terminate JSP

		// display employees of dept
		OracleCachedRowSet crs = new OracleCachedRowSet();
		crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		crs.setUsername("hr");
		crs.setPassword("hr");
		crs.setCommand("select * from employees where department_id = ?");
		crs.setString(1, deptid);
		crs.execute();
		
		// todo : stop here if crs contians no rows and display error message 
	%>
    <p/>
	<table style="width: 100%" border="1">
		<tr>
			<th>Name</th>
			<th>Job</th>
			<th>Salary</th>
		</tr>

		<%
			while (crs.next()) {
		%>

		<tr>
			<td>
			    <%=crs.getString("first_name") %> 
			    <%=crs.getString("last_name") %>
            </td>
			<td><%=crs.getString("job_id")%></td>
			<td><%=crs.getString("salary")%></td>
		</tr>
		<%
			}
		%>

	</table>

</body>
</html>