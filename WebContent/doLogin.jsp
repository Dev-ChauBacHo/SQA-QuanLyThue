<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,dao.*,model.*"%>

<%
	String username = (String)request.getParameter("mst");
	String password = (String)request.getParameter("password");
	Employee Em = new Employee();
	Em.setMst(username);
	Em.setPassword(password);
	
	Login dao =new Login();
	boolean kq = dao.checkLogin(Em);
	
	if(kq){
		session.setAttribute("user", Em.getName());
		session.setAttribute("mst", Em.getMst());
		session.setAttribute("account", Em);
		response.sendRedirect("loginsuccess.jsp");
	}
	else{
		response.sendRedirect("login.jsp?err=fail");
	}
%>