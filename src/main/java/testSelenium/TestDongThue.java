package testSelenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import dao.BillDao;
import dao.DAO;
import model.Bill;

public class TestDongThue extends TestDriver{
	ChromeDriver driver = getDriver();
	String mst = "12345678";
	DAO dao = new DAO();
	Connection con = dao.con;
	int id = 29;
	
	private void login() {
		driver.get("http://localhost:8080/ThueSQA/login.jsp");
		WebElement username = driver.findElement(By.name("mst"));
		username.sendKeys(mst);
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("1");
		driver.findElement(By.name("login_btn")).click();
	}
	
	private void clickDongThue() {
		driver.get("http://localhost:8080/ThueSQA/listBill.jsp");
		driver.findElement(By.xpath("//a[@href='dongthue.jsp?ID=29']")).click();
	}
	
	// DT001
	@Test
	public void testDongThue1() throws SQLException {
		login();
		clickDongThue();
		
		WebElement ten_ngan_hang = driver.findElement(By.name("ten_ngan_hang"));
		ten_ngan_hang.sendKeys("TCB");
		
		WebElement stk = driver.findElement(By.name("stk"));
		stk.sendKeys("03471625371");
		
		Select calc_shipping_provinces = new Select(driver.findElement(By.name("calc_shipping_provinces")));
		calc_shipping_provinces.selectByIndex(1);
		
		Select calc_shipping_district = new Select(driver.findElement(By.name("calc_shipping_district")));
		calc_shipping_district.selectByIndex(1);
		
//		con.setAutoCommit(false);
		driver.findElement(By.name("dongthue_btn")).click();
		checkDB("29");
		
		String rollback_update = "UPDATE bill SET status = -1 WHERE idBill = ? ";
		rollbackUpdate(rollback_update, "29");
		driver.close();
	}
	
	// DT002
	@Test
	public void testDongThue2() throws SQLException {
		login();
		clickDongThue();

		driver.findElement(By.name("dongthue_btn")).click();
		String message = driver.findElement(By.name("ten_ngan_hang")).getAttribute("validationMessage");  
		assertEquals("Vui lòng điền tên ngân hàng", message);
		driver.close();
	}
	
	// DT003
	@Test
	public void testDongThue3() throws SQLException {
		login();
		clickDongThue();

		WebElement ten_ngan_hang = driver.findElement(By.name("ten_ngan_hang"));
		ten_ngan_hang.sendKeys("TCB");
		
		driver.findElement(By.name("dongthue_btn")).click();
		String message = driver.findElement(By.name("stk")).getAttribute("validationMessage");  
		assertEquals("Vui lòng điền STK", message);
		driver.close();
	}
	
	// DT004
	@Test
	public void testDongThue4() throws SQLException {
		login();
		clickDongThue();

		WebElement ten_ngan_hang = driver.findElement(By.name("ten_ngan_hang"));
		ten_ngan_hang.sendKeys("TCB");
		
		WebElement stk = driver.findElement(By.name("stk"));
		stk.sendKeys("03471625371");
		
		driver.findElement(By.name("dongthue_btn")).click();
		String message = driver.findElement(By.name("calc_shipping_provinces")).getAttribute("validationMessage");  
		assertEquals("Vui lòng chọn Tỉnh/TP", message);
		driver.close();
	}
	
	// DT005
	@Test
	public void testDongThue5() throws SQLException {
		login();
		clickDongThue();

		WebElement ten_ngan_hang = driver.findElement(By.name("ten_ngan_hang"));
		ten_ngan_hang.sendKeys("TCB");
		
		WebElement stk = driver.findElement(By.name("stk"));
		stk.sendKeys("03471625371");
		
		Select calc_shipping_provinces = new Select(driver.findElement(By.name("calc_shipping_provinces")));
		calc_shipping_provinces.selectByIndex(1);
		
		driver.findElement(By.name("dongthue_btn")).click();
		String message = driver.findElement(By.name("calc_shipping_district")).getAttribute("validationMessage");  
		assertEquals("Vui lòng chọn cơ quan", message);
		driver.close();
	}
	
	// DT006
	@Test
	public void testDongThue6() throws SQLException {
		login();
		clickDongThue();
		
		WebElement ten_ngan_hang = driver.findElement(By.name("ten_ngan_hang"));
		ten_ngan_hang.sendKeys("TCB1234");
		
		WebElement stk = driver.findElement(By.name("stk"));
		stk.sendKeys("03471625371");
		
		Select calc_shipping_provinces = new Select(driver.findElement(By.name("calc_shipping_provinces")));
		calc_shipping_provinces.selectByIndex(1);
		
		Select calc_shipping_district = new Select(driver.findElement(By.name("calc_shipping_district")));
		calc_shipping_district.selectByIndex(1);
		
//		con.setAutoCommit(false);
		driver.findElement(By.name("dongthue_btn")).click();
		
		try {
			String message = ten_ngan_hang.getAttribute("validationMessage");
			assertEquals("Vui lòng điền tên ngân hàng hợp lệ", message);
		} catch(Exception e) {
			assert false;
		} finally {
		
			String rollback_update = "UPDATE bill SET status = -1 WHERE idBill = ? ";
			rollbackUpdate(rollback_update, "29");
			driver.close();
		}
	}
	
	// DT007
	@Test
	public void testDongThue7() throws SQLException {
		login();
		clickDongThue();
		
		WebElement ten_ngan_hang = driver.findElement(By.name("ten_ngan_hang"));
		ten_ngan_hang.sendKeys("TCB");
		
		WebElement stk = driver.findElement(By.name("stk"));
		stk.sendKeys("@!03471625371");
		
		Select calc_shipping_provinces = new Select(driver.findElement(By.name("calc_shipping_provinces")));
		calc_shipping_provinces.selectByIndex(1);
		
		Select calc_shipping_district = new Select(driver.findElement(By.name("calc_shipping_district")));
		calc_shipping_district.selectByIndex(1);
		
//		con.setAutoCommit(false);
		driver.findElement(By.name("dongthue_btn")).click();
		
		try {
			String message = stk.getAttribute("validationMessage");
			assertEquals("Vui lòng điền STK hợp lệ", message);
		} catch(Exception e) {
			assert false;
		} finally {
		
			String rollback_update = "UPDATE bill SET status = -1 WHERE idBill = ? ";
			rollbackUpdate(rollback_update, "29");
			driver.close();
		}
	}
	
	// DT008
	@Test
	public void testDongThue8() throws SQLException {
		login();
		clickDongThue();
		
		WebElement ten_ngan_hang = driver.findElement(By.name("ten_ngan_hang"));
		ten_ngan_hang.sendKeys("TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT"
				+ "TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
		
		WebElement stk = driver.findElement(By.name("stk"));
		stk.sendKeys("03471625371");
		
		Select calc_shipping_provinces = new Select(driver.findElement(By.name("calc_shipping_provinces")));
		calc_shipping_provinces.selectByIndex(1);
		
		Select calc_shipping_district = new Select(driver.findElement(By.name("calc_shipping_district")));
		calc_shipping_district.selectByIndex(1);
		
//		con.setAutoCommit(false);
		driver.findElement(By.name("dongthue_btn")).click();
		
		try {
			String message = ten_ngan_hang.getAttribute("validationMessage");
			assertEquals("Vui lòng điền tên ngân hàng hợp lệ", message);
		} catch(Exception e) {
			assert false;
		} finally {
		
			String rollback_update = "UPDATE bill SET status = -1 WHERE idBill = ? ";
			rollbackUpdate(rollback_update, "29");
			driver.close();
		}
	}
	
	// DT009
	@Test
	public void testDongThue9() throws SQLException {
		login();
		clickDongThue();
		
		WebElement ten_ngan_hang = driver.findElement(By.name("ten_ngan_hang"));
		ten_ngan_hang.sendKeys("TCB");
		
		WebElement stk = driver.findElement(By.name("stk"));
		stk.sendKeys("0347162537111111111111111111111111111111111111111111111111111");
		
		Select calc_shipping_provinces = new Select(driver.findElement(By.name("calc_shipping_provinces")));
		calc_shipping_provinces.selectByIndex(1);
		
		Select calc_shipping_district = new Select(driver.findElement(By.name("calc_shipping_district")));
		calc_shipping_district.selectByIndex(1);
		
//		con.setAutoCommit(false);
		driver.findElement(By.name("dongthue_btn")).click();
		
		try {
			String message = stk.getAttribute("validationMessage");
			assertEquals("Vui lòng điền STK hợp lệ", message);
		} catch(Exception e) {
			assert false;
		} finally {
		
			String rollback_update = "UPDATE bill SET status = -1 WHERE idBill = ? ";
			rollbackUpdate(rollback_update, "29");
			driver.close();
		}
	}
	
	public void checkDB(String id) throws SQLException {
 		String sql = "SELECT status FROM bill WHERE idBill = ?";
	    try (
	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = con.prepareStatement(sql)) {
	            preparedStatement.setString(1, id);

	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();
	            
	            while (rs.next()) {
	            	assertEquals("0", rs.getString(1));
	            }

	        } catch (SQLException e) {
	            // process sql exception
	            e.printStackTrace();
	        }
 		
	}
	
	public void rollbackUpdate(String rollback_update, String id) throws SQLException {
		int result = 0;
		con.setAutoCommit(true);
 		try(
			PreparedStatement preparedStatement = con.prepareStatement(rollback_update)){
			preparedStatement.setString(1, id);
			result = preparedStatement.executeUpdate();
			System.out.println(preparedStatement);
			System.out.println(result);
 			}
		catch (SQLException e) {
			 e.printStackTrace();
			 }
	}

}
