package dao;
import java.sql.CallableStatement;
import java.sql.ResultSet;

import model.Employee;
public class Login extends DAO{
	public Login() {
		super();
	}
	public boolean checkLogin(Employee Em) {
		boolean kq = false;
		if(Em.getMst().contains("true") || Em.getMst().contains("=")||
				Em.getPassword().contains("true")|| Em.getPassword().contains("=")) return false;
		String sql = "Select * FROM customer WHERE maSoThue = ? and pass = ?";
		try {
			CallableStatement cs = con.prepareCall(sql);
			cs.setString(1, Em.getMst());
			cs.setString(2, Em.getPassword());
			ResultSet rs = cs.executeQuery();
			
			if(rs.next()) {
				Em.setName(rs.getString("name"));
				Em.setMst(rs.getString("maSoThue"));
				kq = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
			kq = false;
		}
		return kq;
	}
}
