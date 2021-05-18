package web;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import dao.DAO;
import model.Bill;

public class BillDaoDongThueTest {

	@Test
	public void testDongThue() throws SQLException {
		DAO dao = new DAO();
		Connection con = dao.con;
		Bill bill1 = new Bill("2021-01-01", "2000000", "1", "0", "87654321", false);
		Bill bill2 = new Bill();
		con.setAutoCommit(false);
		
 		String Update_Bill_SQL = "update bill set status = true where idBill = " + 2;
 		int result =0;
 		try(PreparedStatement preparedStatement = con.prepareStatement(Update_Bill_SQL)){
 				result = preparedStatement.executeUpdate();
 			}
 			catch (SQLException e) {
 			 e.printStackTrace();
 		}
 		
 		
 		String sql = "SELECT status FROM bill WHERE idBill = ?";
	    try (
	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = con.prepareStatement(sql)) {
	            preparedStatement.setString(1, "2");

	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();
	            
	            while (rs.next()) {
	            	assertEquals(true, rs.getBoolean(1));
	            }

	        } catch (SQLException e) {
	            // process sql exception
	            e.printStackTrace();
	        } finally {
	        	 con.rollback();
	        }
 		
	}
}
