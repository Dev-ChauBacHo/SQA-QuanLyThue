<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,dao.*,model.*"%>
<%
if (request.getParameter("logout") != null) {  
    session.invalidate();
    response.sendRedirect("login.jsp");
    return; 
}
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Trang chủ</title>
</head>
<body>
<body>
	<div align="center">
		<h1>Trang chủ</h1>
		<a href="login.jsp">Đăng nhập</a>
		<br>
		<a href="employeeregister.jsp">Đăng ký</a>
	</div>
</body>
</body>
</html>