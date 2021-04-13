<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,dao.*,model.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Trang chủ khai báo thuế</title>
</head>
<body>
<%
	Employee Em = (Employee)session.getAttribute("account");
		if(Em==null){
			response.sendRedirect("login.jsp?err=timeout");
		}
%>
	<div align="center">
		<h1>Đăng nhập thành công</h1>
		<p>Họ tên:<strong><%=session.getAttribute("user") %></strong> </p>
		<p>Mã số thuế:<strong><%=session.getAttribute("mst") %></strong> </p>
		<form action="khaibaothue.jsp " method="post">
     		<input type="submit" value="Khai báo thuế">
    	</form>
    	<form action="listBill.jsp" method="post">
     		<input type="submit" value="Danh sách đã khai báo">
    	</form>
    	<form action="logout.jsp" method="post">
     		<input type="submit" value="Đăng xuất"> 
    	</form>
		<!--<a href="khaibaothue.jsp">Khai bao thue</a>
		<br>
		<a href="listBill.jsp">danh sach da khai bao thue</a>
		<br>
		<a href="home.jsp">Logout</a>-->
	</div>
</body>
</html>