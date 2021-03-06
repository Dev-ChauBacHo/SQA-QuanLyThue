package testJUnit;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import dao.BillDao;
import dao.DAO;
import model.Bill;

public class BillDaoKhaiBaoThueTest {

	private BillDao khaibaothue = new BillDao();
	Bill bill1 = new Bill("2021-01-01", "2000000", "1", "0", "87654321", "-1");
	Bill bill2 = new Bill("2021-03-12", "1000000", "1", "0", "87654321", "-1");
	Bill bill3 = new Bill("2021-05-09", "12000000", "1", "1000000", "87654321", "-1");
	Bill bill4 = new Bill("2021-23-05", "15000000", "1", "4000000", "87654321", "-1");
	Bill bill5 = new Bill();
	DAO dao = new DAO();
	Connection con = dao.con;
	
	@Test
	public void testKhaiBaoThue1() throws SQLException, ClassNotFoundException {
		
		con.setAutoCommit(false);
		khaibaothue.khaiBaoThue(bill1);
		testDB(bill1);
	
	}  
	
	@Test
	public void testKhaiBaoThue2() throws SQLException, ClassNotFoundException {
		con.setAutoCommit(false);
		khaibaothue.khaiBaoThue(bill2);
		testDB(bill2);
	}
	
	@Test
	public void testKhaiBaoThue3() throws SQLException, ClassNotFoundException {
		con.setAutoCommit(false);
		khaibaothue.khaiBaoThue(bill3);
		testDB(bill3);
	}
	
	@Test
	public void testKhaiBaoThue4() throws SQLException, ClassNotFoundException {
		con.setAutoCommit(false);
		khaibaothue.khaiBaoThue(bill4);
		testDB(bill4);
	}
	
	public void testDB(Bill bill1) throws SQLException {
	    Bill bill2 = new Bill();
		String sql = "SELECT * FROM bill WHERE date = ? AND luong = ? AND songuoi = ? AND tienthue = ? AND maSoThue = ?";
	    try (
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, bill1.getDate());
            preparedStatement.setString(2, bill1.getLuong());
            preparedStatement.setString(3, bill1.getSonguoi());
            preparedStatement.setString(4, bill1.getTienThue());
            preparedStatement.setString(5, bill1.getMst());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
            	bill2 = new Bill(
            			rs.getString(2),
            			rs.getString(3),
            			rs.getString(4),
            			rs.getString(5),
            			rs.getString(6),
            			rs.getString(7));
            	System.out.println(bill2.toString());
            }
            
    	    assertEquals(bill2.getDate(), bill1.getDate());
    	    assertEquals(bill2.getLuong(), bill1.getLuong());
    	    assertEquals(bill2.getSonguoi(), bill1.getSonguoi());
    	    assertEquals(bill2.getTienThue(), bill1.getTienThue());
    	    assertEquals(bill2.getMst(), bill1.getMst());
    	    assertEquals(bill2.getStatus(), bill1.getStatus());

        } catch (SQLException e) {
            // process sql exception
            e.printStackTrace();
        } finally {
        	 con.rollback();
        	String rollback_sql = "DELETE From bill WHERE date = ? AND luong = ? AND songuoi = ? AND tienthue = ? AND maSoThue = ?";
//	        	RollbackDB(rollback_sql);
        }
	    
	}
	
	public void rollbackDB(String rollback_sql) {
//		String rollback_sql = "Delete From bill where date = ? AND luong = ? AND songuoi = ? AND tienthue = ? AND maSoThue = ?";
			int result = 0;
		try (
	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = con.prepareStatement(rollback_sql)) {
	            preparedStatement.setString(1, bill1.getDate());
	            preparedStatement.setString(2, bill1.getLuong());
	            preparedStatement.setString(3, bill1.getSonguoi());
	            preparedStatement.setString(4, bill1.getTienThue());
	            preparedStatement.setString(5, bill1.getMst());

	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            result = preparedStatement.executeUpdate();
	            System.out.println("result:::::::::::::::::" + result);

	        } catch (SQLException e) {
	            // process sql exception
	            e.printStackTrace();
	        }
		}

}
