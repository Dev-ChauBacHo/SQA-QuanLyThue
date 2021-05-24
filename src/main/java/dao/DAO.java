package dao;

import java.sql.Connection;
import java.sql.DriverManager;
public class DAO {
	public static Connection con = getConnection();
	
	public DAO() {
//		if(con == null) {
////			String dbUrl = "jdbc:mysql://localhost:3306/qlthue?useSSL=false";
//			String dbUrl = "jdbc:mysql://localhost:3306/quanly_thue";
//			String dbClass = "com.mysql.cj.jdbc.Driver";
//			try {
//				Class.forName(dbClass);
//				con = DriverManager.getConnection(dbUrl, "root", "");
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
	}

	public static Connection getConnection() {
		Connection conn;
		
		String dbUrl = "jdbc:mysql://localhost:3306/quanly_thue";
		String dbClass = "com.mysql.cj.jdbc.Driver";
		try {
			Class.forName(dbClass);
			return DriverManager.getConnection(dbUrl, "root", "root");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
