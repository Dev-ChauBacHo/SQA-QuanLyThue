package testJUnit;

import java.sql.Connection;
import java.util.ArrayList;

import org.junit.Test;

import dao.BillDao;
import dao.DAO;

public class BillDaoFindInforTest {
	Connection con = DAO.con;
	private BillDao billDao = new BillDao(con);
	
	// idBill va mst trung khop
	@Test
	public void testFindInfor1() throws Exception {
		String[] list = billDao.findInfor("1", "12345678");
		if (list[0].equals("Dat") && list[1].equals("0"))
			assert true;
		else
			assert false;
	}
	
	// idBill va mst khong trung khop
	@Test
	public void testFindInfor2() throws Exception {
		String[] list = billDao.findInfor("1", "87654321");
		if (list == null)
			assert true;
		else
			assert false;
	}
}
