package dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.CallableStatement;
import java.sql.ResultSet;

import model.Bill;
import model.Employee;

public class CustomerDAO extends DAO {
	public CustomerDAO() {
		super();
	}
	public List<Bill> getAll(String mst) {
		List<Bill> listBill = null;
		listBill = new ArrayList<Bill>();
		String sql = "Select * From bill Where maSoThue = ?";
		try {
			CallableStatement cs = con.prepareCall(sql);
			cs.setString(1, mst);
			ResultSet rs = cs.executeQuery();
			while(rs.next()) {
				Bill b = new Bill();
				b.setDate(rs.getString("date"));
				b.setLuong(rs.getString("luong"));
				b.setSonguoi(rs.getString("songuoi"));
				b.setTienThue(rs.getString("tienthue"));
				listBill.add(b);
			}
			return listBill;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public void khaibaothue(Bill bill) {
		String INSERT_USERS_SQL = "INSERT INTO bill" +
	            "  (date, luong, songuoi, tienthue, maSoThue) VALUES " +
	            " (?, ?, ?, ?, ?);";
		try {
			CallableStatement cs = con.prepareCall(INSERT_USERS_SQL);
			cs.setString(1, bill.getDate());
            cs.setString(2, bill.getLuong());
            cs.setString(3, bill.getSonguoi());
            cs.setString(4, bill.getTienThue());
            cs.setString(5, bill.getMst());
            
            cs.executeQuery();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
