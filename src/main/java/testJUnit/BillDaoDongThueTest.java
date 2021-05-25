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

public class BillDaoDongThueTest {
	DAO dao = new DAO();
	Connection con = dao.con;
	String id="29";
	String id1="4";
	private BillDao dongthue = new BillDao();
	
	// Chua Dong thanh Dang cho
	@Test
	public void testDongThue1() throws SQLException, ClassNotFoundException {
		con.setAutoCommit(false);
		if (dongthue.dongThue(id) == 1)
			checkDB(id);
		else {
			assert false;
		}
		con.rollback();
	}
	
	// id không ton tai
	@Test
	public void testDongThue2() throws SQLException, ClassNotFoundException {
		con.setAutoCommit(false);
		if (dongthue.dongThue(id1) > 0) {
			assert false;
		} else {
			assert true;
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
            
            if (rs.next()) {
            	assertEquals("0", rs.getString(1));
            } else {
            	
            }

        } catch (SQLException e) {
            // process sql exception
            e.printStackTrace();
        } 
//	    finally {
//        	 con.rollback();
//        }
	}
 	
}
