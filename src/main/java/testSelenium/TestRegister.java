package testSelenium;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import dao.DAO;


public class TestRegister extends TestDriver{
	String mst = "1111111111";
	String name1 = "Dat";
	String email1 = "A@gmail.com";
	String phone1 ="123456789";
	String pin1 = "123456";
	String pass1 = "12345678";
	DAO dao = new DAO();
	Connection con = dao.con;
	ChromeDriver driver = getDriver();
		@Test
		public void register_test1() {
			driver.get("http://localhost:8080/ThueSQA/home.jsp");
			driver.findElement(By.xpath("//a[@href='employeeregister.jsp']")).click();
			String title = driver.getTitle();
			assertEquals("Đăng ký", title);
			driver.close();
		}
		@Test
		public void register_test2() throws SQLException {
			driver.get("http://localhost:8080/ThueSQA/employeeregister.jsp");
			WebElement username = driver.findElement(By.name("mst"));
			username.sendKeys("1111111111");
			WebElement name = driver.findElement(By.name("name"));
			name.sendKeys("Dat");
			WebElement sdt = driver.findElement(By.name("phone"));
			sdt.sendKeys("123456789");
			WebElement email = driver.findElement(By.name("email"));
			email.sendKeys("A@gmail.com");
			WebElement diachi = driver.findElement(By.name("address"));
			diachi.sendKeys("HN");
			WebElement pin = driver.findElement(By.name("pin"));
			pin.sendKeys("123456");
			WebElement pass = driver.findElement(By.name("password"));
			pass.sendKeys("12345678");
			
			driver.findElement(By.name("register_btn")).click();
			
			String title = driver.getTitle();
			String expect = "Đăng ký thành công";
			assertEquals(expect, title);
			String rollback = "Delete from customers Where maSoThue = ? And name = ? And phone = ? And email = ? And pass = ?";
			rollbackUpdate(rollback, mst, name1, phone1, email1, pass1);
			driver.close();
		}
		@Test
		public void register_test7() throws SQLException {
			driver.get("http://localhost:8080/ThueSQA/employeeregister.jsp");
			WebElement username = driver.findElement(By.name("mst"));
			username.sendKeys("111111111000000000");
			WebElement name = driver.findElement(By.name("name"));
			name.sendKeys("Dat");
			WebElement sdt = driver.findElement(By.name("phone"));
			sdt.sendKeys("123456789");
			WebElement email = driver.findElement(By.name("email"));
			email.sendKeys("A@gmail.com");
			WebElement diachi = driver.findElement(By.name("address"));
			diachi.sendKeys("HN");
			WebElement pin = driver.findElement(By.name("pin"));
			pin.sendKeys("123456");
			WebElement pass = driver.findElement(By.name("password"));
			pass.sendKeys("12345678");
			
			driver.findElement(By.name("register_btn")).click();
			try {
				String message = username.getAttribute("validationMessage");
				String title = driver.getTitle();
				assertEquals("Vui lòng nhập Mã số thuế", message);
			}catch(Exception e) {
				assert false;
			}finally {
				String rollback = "Delete from customers Where maSoThue = ? And name = ? And phone = ? And email = ? And pass = ?";
			rollbackUpdate(rollback, "111111111000000000", name1, phone1, email1, pass1);
			driver.close();
			}
			
			
			
		}
		@Test
		public void register_test8() throws SQLException {
			driver.get("http://localhost:8080/ThueSQA/employeeregister.jsp");
			WebElement username = driver.findElement(By.name("mst"));
			username.sendKeys("111111");
			WebElement name = driver.findElement(By.name("name"));
			name.sendKeys("Dat");
			WebElement sdt = driver.findElement(By.name("phone"));
			sdt.sendKeys("123456789");
			WebElement email = driver.findElement(By.name("email"));
			email.sendKeys("A@gmail.com");
			WebElement diachi = driver.findElement(By.name("address"));
			diachi.sendKeys("HN");
			WebElement pin = driver.findElement(By.name("pin"));
			pin.sendKeys("123456");
			WebElement pass = driver.findElement(By.name("password"));
			pass.sendKeys("12345678");
			
			driver.findElement(By.name("register_btn")).click();
			try {
				String message = username.getAttribute("validationMessage");
				String title = driver.getTitle();
				assertEquals("Vui lòng nhập Mã số thuế", message);
			}catch(Exception e) {
				assert false;
			}finally {
				String rollback = "Delete from customers Where maSoThue = ? And name = ? And phone = ? And email = ? And pass = ?";
			rollbackUpdate(rollback, "111111", name1, phone1, email1, pass1);
			driver.close();
			}
		}
		@Test
		public void register_test10() throws SQLException {
			driver.get("http://localhost:8080/ThueSQA/employeeregister.jsp");
			WebElement username = driver.findElement(By.name("mst"));
			username.sendKeys(mst);
			WebElement name = driver.findElement(By.name("name"));
			name.sendKeys("Dat^^");
			WebElement sdt = driver.findElement(By.name("phone"));
			sdt.sendKeys("123456789");
			WebElement email = driver.findElement(By.name("email"));
			email.sendKeys("A@gmail.com");
			WebElement diachi = driver.findElement(By.name("address"));
			diachi.sendKeys("HN");
			WebElement pin = driver.findElement(By.name("pin"));
			pin.sendKeys("123456");
			WebElement pass = driver.findElement(By.name("password"));
			pass.sendKeys("12345678");
			
			driver.findElement(By.name("register_btn")).click();
			try {
				String message = name.getAttribute("validationMessage");
				String title = driver.getTitle();
				assertEquals("Vui lòng nhập tên", message);
			}catch(Exception e) {
				assert false;
			}finally {
				String rollback = "Delete from customers Where maSoThue = ? And name = ? And phone = ? And email = ? And pass = ?";
			rollbackUpdate(rollback, mst, "Dat^^", phone1, email1, pass1);
			driver.close();
			}
		}
		@Test
		public void register_test12() throws SQLException {
			driver.get("http://localhost:8080/ThueSQA/employeeregister.jsp");
			WebElement username = driver.findElement(By.name("mst"));
			username.sendKeys(mst);
			WebElement name = driver.findElement(By.name("name"));
			name.sendKeys(name1);
			WebElement sdt = driver.findElement(By.name("phone"));
			sdt.sendKeys("123456789abc");
			WebElement email = driver.findElement(By.name("email"));
			email.sendKeys("A@gmail.com");
			WebElement diachi = driver.findElement(By.name("address"));
			diachi.sendKeys("HN");
			WebElement pin = driver.findElement(By.name("pin"));
			pin.sendKeys("123456");
			WebElement pass = driver.findElement(By.name("password"));
			pass.sendKeys("12345678");
			
			driver.findElement(By.name("register_btn")).click();
			try {
				String message = sdt.getAttribute("validationMessage");
				String title = driver.getTitle();
				assertEquals("Vui lòng nhập số điện thoại", message);
			}catch(Exception e) {
				assert false;
			}finally {
				String rollback = "Delete from customers Where maSoThue = ? And name = ? And phone = ? And email = ? And pass = ?";
			rollbackUpdate(rollback, mst, name1, "123456789abc", email1, pass1);
			driver.close();
			}
		}
		@Test
		public void register_test13() throws SQLException {
			driver.get("http://localhost:8080/ThueSQA/employeeregister.jsp");
			WebElement username = driver.findElement(By.name("mst"));
			username.sendKeys(mst);
			WebElement name = driver.findElement(By.name("name"));
			name.sendKeys(name1);
			WebElement sdt = driver.findElement(By.name("phone"));
			sdt.sendKeys("12345");
			WebElement email = driver.findElement(By.name("email"));
			email.sendKeys("A@gmail.com");
			WebElement diachi = driver.findElement(By.name("address"));
			diachi.sendKeys("HN");
			WebElement pin = driver.findElement(By.name("pin"));
			pin.sendKeys("123456");
			WebElement pass = driver.findElement(By.name("password"));
			pass.sendKeys("12345678");
			
			driver.findElement(By.name("register_btn")).click();
			try {
				String message = sdt.getAttribute("validationMessage");
				String title = driver.getTitle();
				assertEquals("Vui lòng nhập số điện thoại", message);
			}catch(Exception e) {
				assert false;
			}finally {
				String rollback = "Delete from customers Where maSoThue = ? And name = ? And phone = ? And email = ? And pass = ?";
			rollbackUpdate(rollback, mst, name1, "12345", email1, pass1);
			driver.close();
			}
		}
		@Test
		public void register_test14() throws SQLException {
			driver.get("http://localhost:8080/ThueSQA/employeeregister.jsp");
			WebElement username = driver.findElement(By.name("mst"));
			username.sendKeys(mst);
			WebElement name = driver.findElement(By.name("name"));
			name.sendKeys(name1);
			WebElement sdt = driver.findElement(By.name("phone"));
			sdt.sendKeys("123456789112");
			WebElement email = driver.findElement(By.name("email"));
			email.sendKeys("A@gmail.com");
			WebElement diachi = driver.findElement(By.name("address"));
			diachi.sendKeys("HN");
			WebElement pin = driver.findElement(By.name("pin"));
			pin.sendKeys("123456");
			WebElement pass = driver.findElement(By.name("password"));
			pass.sendKeys("12345678");
			
			driver.findElement(By.name("register_btn")).click();
			try {
				String message = sdt.getAttribute("validationMessage");
				String title = driver.getTitle();
				assertEquals("Vui lòng nhập số điện thoại", message);
			}catch(Exception e) {
				assert false;
			}finally {
				String rollback = "Delete from customers Where maSoThue = ? And name = ? And phone = ? And email = ? And pass = ?";
			rollbackUpdate(rollback, mst, name1, "123456789112", email1, pass1);
			driver.close();
			}
		}
		@Test
		public void register_test16() throws SQLException {
			driver.get("http://localhost:8080/ThueSQA/employeeregister.jsp");
			WebElement username = driver.findElement(By.name("mst"));
			username.sendKeys(mst);
			WebElement name = driver.findElement(By.name("name"));
			name.sendKeys(name1);
			WebElement sdt = driver.findElement(By.name("phone"));
			sdt.sendKeys(phone1);
			WebElement email = driver.findElement(By.name("email"));
			email.sendKeys("A");
			WebElement diachi = driver.findElement(By.name("address"));
			diachi.sendKeys("HN");
			WebElement pin = driver.findElement(By.name("pin"));
			pin.sendKeys("123456");
			WebElement pass = driver.findElement(By.name("password"));
			pass.sendKeys("12345678");
			
			driver.findElement(By.name("register_btn")).click();
			try {
				String message = sdt.getAttribute("validationMessage");
				String title = driver.getTitle();
				assertEquals("Vui lòng nhập số điện thoại", message);
			}catch(Exception e) {
				assert false;
			}finally {
				String rollback = "Delete from customers Where maSoThue = ? And name = ? And phone = ? And email = ? And pass = ?";
			rollbackUpdate(rollback, mst, name1, phone1, "A", pass1);
			driver.close();
			}
		}
		@Test
		public void register_test18() throws SQLException {
			driver.get("http://localhost:8080/ThueSQA/employeeregister.jsp");
			WebElement username = driver.findElement(By.name("mst"));
			username.sendKeys("1111111111");
			WebElement name = driver.findElement(By.name("name"));
			name.sendKeys("Dat");
			WebElement sdt = driver.findElement(By.name("phone"));
			sdt.sendKeys("123456789");
			WebElement email = driver.findElement(By.name("email"));
			email.sendKeys("A@gmail.com");
			WebElement diachi = driver.findElement(By.name("address"));
			diachi.sendKeys("HN");
			WebElement pin = driver.findElement(By.name("pin"));
			pin.sendKeys("123456");
			WebElement pass = driver.findElement(By.name("password"));
			pass.sendKeys("123456");
			
			driver.findElement(By.name("register_btn")).click();
			try {
				String message = pass.getAttribute("validationMessage");
				String title = driver.getTitle();
				assertEquals("Vui lòng nhập Mật khẩu", message);
			}catch(Exception e) {
				assert false;
			}finally {
				String rollback = "Delete from customers Where maSoThue = ? And name = ? And phone = ? And email = ? And pass = ?";
			rollbackUpdate(rollback, "1111111111", name1, phone1, email1, "123456");
			driver.close();
			}
		}
		@Test
		public void register_test3() {
			driver.get("http://localhost:8080/ThueSQA/employeeregister.jsp");
			driver.findElement(By.name("register_btn")).click();
			String message = driver.findElement(By.name("mst")).getAttribute("validationMessage"); 
			assertEquals("Vui lòng nhập Mã số thuế", message);
			driver.close();
		}
		@Test
		public void register_test9() {
			driver.get("http://localhost:8080/ThueSQA/employeeregister.jsp");
			WebElement mst = driver.findElement(By.name("mst"));
			mst.sendKeys("1111111111");
			driver.findElement(By.name("register_btn")).click();
			String message = driver.findElement(By.name("name")).getAttribute("validationMessage"); 
			assertEquals("Vui lòng nhập tên", message);
			driver.close();
		}
		@Test
		public void register_test11() {
			driver.get("http://localhost:8080/ThueSQA/employeeregister.jsp");
			WebElement mst = driver.findElement(By.name("mst"));
			mst.sendKeys("11111111111");
			WebElement name = driver.findElement(By.name("name"));
			name.sendKeys("Dat");
			driver.findElement(By.name("register_btn")).click();
			String message = driver.findElement(By.name("phone")).getAttribute("validationMessage"); 
			assertEquals("Vui lòng nhập số điện thoại", message);
			driver.close();
		}
		@Test
		public void register_test15() {
			driver.get("http://localhost:8080/ThueSQA/employeeregister.jsp");
			WebElement mst = driver.findElement(By.name("mst"));
			mst.sendKeys("11111111111");
			WebElement name = driver.findElement(By.name("name"));
			name.sendKeys("Dat");
			WebElement phone = driver.findElement(By.name("phone"));
			phone.sendKeys("123456789");
			driver.findElement(By.name("register_btn")).click();
			String message = driver.findElement(By.name("email")).getAttribute("validationMessage"); 
			assertEquals("Vui lòng nhập email", message);
			driver.close();
		}
		@Test
		public void register_test17() {
			driver.get("http://localhost:8080/ThueSQA/employeeregister.jsp");
			WebElement mst = driver.findElement(By.name("mst"));
			mst.sendKeys("11111111111");
			WebElement name = driver.findElement(By.name("name"));
			name.sendKeys("Dat");
			WebElement phone = driver.findElement(By.name("phone"));
			phone.sendKeys("123456789");
			WebElement email = driver.findElement(By.name("email"));
			email.sendKeys(email1);
			driver.findElement(By.name("register_btn")).click();
			String message = driver.findElement(By.name("password")).getAttribute("validationMessage"); 
			assertEquals("Vui lòng nhập Mật khẩu", message);
			driver.close();
		}
		public void rollbackUpdate(String rollback_update, String mst, String name, String phone, String email,  String pass) throws SQLException {
			int result = 0;
			con.setAutoCommit(true);
	 		try(
				PreparedStatement preparedStatement = con.prepareStatement(rollback_update)){
	 			preparedStatement.setString(1, mst);
	 			preparedStatement.setString(2, name);
	 			preparedStatement.setString(3, phone);
	 			preparedStatement.setString(4, email);
	 			preparedStatement.setString(5, pass);
				result = preparedStatement.executeUpdate();
				System.out.println(preparedStatement);
				System.out.println(result);
	 			}
			catch (SQLException e) {
				 e.printStackTrace();
				 }
		}
}

