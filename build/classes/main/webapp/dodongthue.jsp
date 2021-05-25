<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,dao.*,model.*"%>

<%
String ID = (String)request.getParameter("ID");
String tnh = (String)request.getParameter("ten_ngan_hang");
String stk = (String)request.getParameter("stk");
String calc_shipping_provinces = (String)request.getParameter("calc_shipping_provinces");
String calc_shipping_district = (String)request.getParameter("calc_shipping_district");

System.out.println(tnh);
System.out.println(stk);
System.out.println(calc_shipping_provinces);
System.out.println(calc_shipping_district);
	
	BillDao dao = new BillDao();
	dao.dongThue(ID);
	
	response.sendRedirect("listBill.jsp");
%>