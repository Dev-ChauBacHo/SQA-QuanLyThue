package testJUnit;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import dao.BillDao;
import dao.DAO;
import model.Bill;

public class BillDaoFindListTest {
	Connection con = DAO.con;
	private BillDao billDao = new BillDao(con);
	
	// mst ton tai
	@Test
	public void findListTest1() throws SQLException {
		String mst = "12345678";
		ArrayList<Bill> list = billDao.findList(mst);
		assertEquals(countBill(mst), list.size());
	}

	// mst ko ton tai
	@Test
	public void findListTest2() throws SQLException {
		String mst = "12345679";
		ArrayList<Bill> list = billDao.findList(mst);
		assertEquals(countBill(mst), list.size());
	}
	
	private int countBill(String mst) throws SQLException {
		java.sql.CallableStatement cs = con.prepareCall("SELECT COUNT(*) AS total FROM bill WHERE maSoThue = "+ mst);
		ResultSet rs = cs.executeQuery();
		if (rs.next()) {
			return rs.getInt("total");
		} else {
			return 0;
		}
	}
}
