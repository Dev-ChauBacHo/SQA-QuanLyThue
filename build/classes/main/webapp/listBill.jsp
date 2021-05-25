<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,java.sql.Connection,java.sql.CallableStatement,java.sql.ResultSet,dao.*,model.*"
   %>
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

		
		ArrayList<Bill> list = (new BillDao()).findList(session.getAttribute("mst").toString());
		for (Bill i: list)
		{
			%>
			<tr>
		     <td> <%=i.getIdBill() %></td>
		     <td> <%=i.getMst()%></td>

		     <td><%=i.getDate()%></td>

		     <td><%=i.getLuong()%></td>

		     <td><%=i.getSonguoi()%></td>

		     <td><%=i.getTienThue()%></td>
		     <%
		     	String status = i.getStatus();
		     	if (status.equals("-1") ){%>
		     		<td> <a href="dongthue.jsp?ID=<%=i.getIdBill() %>">Đóng thuế</a></td>
		     	<%}
		     	else if (status.equals("1")){%>
		     	<td> Đã đóng</td>
		     	<%} else {
		     		%>
			     	<td> Đang chờ</td>
			     	<%
		     	} %>
		    </tr>
		    <%
		}
}catch(Exception e){
	out.print(e);
}
%>
	</table>
	</div>
	</body>
</html>
