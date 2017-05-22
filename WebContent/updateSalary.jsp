<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>Update Salary</h2>
	<form action="updateSalary.jsp" >
		Employee Id <br /> <input type="number" name="id" value="${param.id}" />
		<p></p>
		New Salary <br /> <input type="text" name="salary" maxlength="6"  value="${param.salary}" />
		<p></p>
		<input type="submit" value="Update" />
	</form>
	
	<%
	   if (request.getParameter("id") == null)
		   return; 
	%>
	
	<jsp:useBean id="emp"  class="beans.EmployeeBean" scope="page"></jsp:useBean>
	<jsp:setProperty property="*" name="emp"/>
	
	<%
	     emp.updateSalary();
	%>
	
	<h4> ${emp.message} </h4>
	
	
</body>
</html>