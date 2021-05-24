<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,dao.*,model.*"%>

<%
String Date = (String)request.getParameter("date");
	String Luong = (String)request.getParameter("luong");
	String nguoi = (String)request.getParameter("songuoi");
	String mst = (String)request.getParameter("mst");
	Bill bill = new Bill();
	bill.setDate(Date);
	bill.setLuong(Luong);
	bill.setSonguoi(nguoi);
	
	long songuoi = Long.parseLong(nguoi);
    long soLuong = Long.parseLong(Luong);
    
    BillDao dao = new BillDao(DAO.con);
    long tienthue = dao.tinhTienThue(soLuong, songuoi);
    bill.setTienThue(String.valueOf(tienthue));
    bill.setMst(mst);
    dao.khaiBaoThue(bill);
    response.sendRedirect("listBill.jsp");
%>

//Éo đc 