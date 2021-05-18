<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,dao.*,model.*"%>

<%
	
	
	String ID = (String)request.getParameter("ID");
	
	BillDao dao = new BillDao();
	dao.DongThue(ID);
	
	response.sendRedirect("listBill.jsp");
	
	
%>