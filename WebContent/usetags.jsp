<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.srikanthtechnologies.com/may12" prefix="st" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Use Tags</title>
</head>
<body>

<select>
  <st:jobs3>
     <option value="${id}">${title}</option>
  </st:jobs3>
</select>


<ul>
 <st:jobs3>
     <li style="color:red">${title}, ${min} </li> 
 </st:jobs3>
</ul>



<st:jobs/>

<st:jobs2 title="man" />
 
     
     
 
</body>
</html>