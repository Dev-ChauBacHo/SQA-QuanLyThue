<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,dao.*,model.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Đăng ký</title>
</head>
<body>
 <div align="center">
  <h1>Đăng ký</h1>
  <form action="<%= request.getContextPath() %>/register" method="post">
   <table style="with: 80%">
    <tr>
     <td>Mã số thuế</td>
     <td><input type="number" name="mst" required oninvalid="this.setCustomValidity('Vui lòng nhập Mã số thuế')" onchange="setCustomValidity('')"/></td>
    </tr>
    <tr>
     <td>Tên</td>
     <td><input type="text" name="name" required oninvalid="this.setCustomValidity('Vui lòng nhập tên')" onchange="setCustomValidity('')"/></td>
    </tr>
    <tr>
     <td>Số điện thoại</td>
     <td><input type="text" name="phone" required oninvalid="this.setCustomValidity('Vui lòng nhập số điện thoại')" onchange="setCustomValidity('')"/></td>
    </tr>
    <tr>
     <td>Email</td>
     <td><input type="text" name="email" required oninvalid="this.setCustomValidity('Vui lòng nhập email')" onchange="setCustomValidity('')"/></td>
    </tr>
    <tr>
     <td>Địa chỉ</td>
     <td><input type="text" name="address" /></td>
    </tr>
    <tr>
     <td>Mã PIN</td>
     <td><input type="text" name="pin" /></td>
    </tr>
    <tr>
     <td>Mật khẩu</td>
     <td><input type="password" name="password" required oninvalid="this.setCustomValidity('Vui lòng nhập Mật khẩu')" onchange="setCustomValidity('')"/></td>
    </tr>
   </table>
   <input type="submit" name = "register_btn" value="Submit" />
  </form>
 </div>
</body>
</html>