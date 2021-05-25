<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,dao.*,model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Khai báo thuế</title>
</head>
<body>
<%
  Employee Em = (Employee)session.getAttribute("account");
    if(Em==null){
      response.sendRedirect("login.jsp?err=timeout");
    }
%>
<div align="center">
  <h1>Khai báo thuế</h1>
  <form action="doThemBill.jsp" method="post">
   <table style="with: 80%">
    <tr>
     <td>Mã số thuế</td>
     <td><input type="text" name="mst" id="mst" value="<%=session.getAttribute("mst")%>" readonly /></td>
    </tr>
    <tr>
     <td>Ngày khai báo</td>
     <td><input type="text" name="date" required oninvalid="this.setCustomValidity('Vui lòng điền ngày thanh toán')" onchange="setCustomValidity('')" name="date" id="date" /></td>
    </tr>
    <tr>
     <td>Thu nhập cá nhân</td>
     <td><input type="number" min = "0" name="luong" required oninvalid="this.setCustomValidity('Vui lòng điền thu thập')" onchange="setCustomValidity('')" name="luong" id="luong" /></td>
    </tr>
    <tr>
     <td>Số người phụ thuộc</td>
     <td><input type="number" min = "0" name="songuoi" required oninvalid="this.setCustomValidity('Vui lòng điền số người phụ thuộc')" onchange="setCustomValidity('')" name="songuoi" id="songuoi"/></td>
    </tr>

   </table>
   <input type="submit" name = "submit_btn" value="Khai báo" />
  </form>
 </div>
</body>
</html>