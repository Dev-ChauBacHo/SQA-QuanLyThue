<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,java.sql.Connection,java.sql.CallableStatement,java.sql.ResultSet,dao.*,model.*"%>
<%
	Employee Em = (Employee)session.getAttribute("account");
		if(Em==null){
			response.sendRedirect("login.jsp?err=timeout");
		}
%>
<html>
<head>
	
		<title>Hóa đơn thuế</title>
		
		<!--css for div main class and table -->
		<style type="text/css">
		
		.main
		{
			width:700px;;
			margin-left:250px;
			padding: 10px;
			border: 5px solid grey;
			
		}
		table
		{
			font-family: arial, sans-serif;
			border-collapse: collapse;
			width: 600px;
		}
		td
		{
			border: 5px solid silver;
			text-align: center;
			padding: 8px;
		}
		</style>
		
		
	</head>	
	<body>
	<div align="center">
	<table style="with: 80%">
		<tr>
		<th>ID</th>
		<th>Mã số thuế</th>
		<th>Ngày khai báo</th>
		<th>Thu thập cá nhân</th>
		<th>Số người phụ thuộc</th>
		<th>Tiền thuế</th>
		<th>Trạng thái</th>
		</tr>
	<%
	try
{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanly_thue?allowPublicKeyRetrieval=true&useSSL=false","root","root");
		CallableStatement cs = con.prepareCall("select * from bill where maSoThue = " + session.getAttribute("mst"));
		
		ResultSet rs = cs.executeQuery();
		while(rs.next())
		{
			int i=0;
			%>
			<tr>
		     <td> <%=rs.getString("idBill") %></td>
		     <td> <%=rs.getString("maSoThue")%></td>

		     <td><%=rs.getString("date")%></td>

		     <td><%=rs.getString("luong")%></td>

		     <td><%=rs.getString("songuoi")%></td>

		     <td><%=rs.getString("tienthue")%></td>
		     <%
		     	if (rs.getBoolean("status") == false ){%>
		     		<td> <a href="dongthue.jsp?ID=<%=rs.getString("idBill") %>">Đóng thuế</a></td>
		     	<%}
		     	else {%>
		     	<td> Đã đóng</td>
		     	<%} %>
		    </tr>
		    <%
		    i++;
		}
}catch(Exception e){
	out.print(e);
}
%>
	</table>
	</div>
	</body>
</html>
