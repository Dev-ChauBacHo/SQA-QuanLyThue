<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList,dao.*,model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
</head>
<body>
<%
	if(request.getParameter("err") !=null && request.getParameter("err").equalsIgnoreCase("timeout")){
		%> <h4>Hết phiên làm việc. Làm ơn đăng nhập lại!</h4><%
	}else if(request.getParameter("err") != null && request.getParameter("err").equalsIgnoreCase("fail")){
		%> <h4 color="red">Sai tên đăng nhập/mật khẩu!</h4><%
	}
%>
	<div align="center">
		<h1>Đăng nhập</h1>
		<form name="dangnhap" action="doLogin.jsp" method = "post">
			<table style="with: 100%">
				<tr>
					<td>Mã số thuế</td>
					<td><input type="text" name="mst" id="mst" required/></td>
				</tr>
				<tr>
					<td>Mật khẩu</td>
					<td><input type="password" name="password" id="password" required/></td>
				</tr>

			</table>
			<input type="submit" value="Đăng nhập" />
		</form>
	</div>
</body>
</html>