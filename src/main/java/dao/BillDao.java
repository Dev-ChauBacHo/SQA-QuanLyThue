package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.CallableStatement;

import model.Bill;


public class BillDao extends DAO {
	
	public BillDao() {
		
	}
	
	public BillDao(Connection conn) {
		this.con = conn;
	}
	
 	public int khaiBaoThue(Bill bill) throws ClassNotFoundException {
        String INSERT_Bill_SQL = "INSERT INTO bill" +
            "  (date, luong, songuoi, tienthue, maSoThue, status) VALUES " +
            " (?, ?, ?, ?, ?, ?);";

        int result = 0;

        try (
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = con.prepareStatement(INSERT_Bill_SQL)) {
            preparedStatement.setString(1, bill.getDate());
            preparedStatement.setString(2, bill.getLuong());
            preparedStatement.setString(3, bill.getSonguoi());
            preparedStatement.setString(4, bill.getTienThue());
            preparedStatement.setString(5, bill.getMst());
            preparedStatement.setString(6, bill.getStatus());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }
 	
 	public int dongThue(String id) throws ClassNotFoundException {
 		String Update_Bill_SQL = "UPDATE bill SET status = 0 WHERE idBill = " + id;
 		int result = 0;
 		try (PreparedStatement preparedStatement = con.prepareStatement(Update_Bill_SQL)){
 				result = preparedStatement.executeUpdate();
		}
		catch (SQLException e) {
			printSQLException(e);
		}
 		return result;
 	}
 	
 	public String[] findInfor(String id, String mst) throws Exception {
 		String[] s = new String[2];
 		java.sql.CallableStatement cs = con.prepareCall("SELECT * FROM bill WHERE idBill = "+ id);
		java.sql.CallableStatement cs1 = con.prepareCall("SELECT name FROM customers WHERE maSoThue = "+ mst);
		ResultSet rs = cs.executeQuery();
		ResultSet rs1 = cs1.executeQuery();
		
		if (rs.next() && rs1.next()){
			if (rs.getString("maSoThue").equals(mst)) {
				s[0] = rs1.getString("name");
				s[1] = rs.getString("tienthue");
				return s;
			} else {
				return null;
			}
		}
		return null;
	}
 	
 	public ArrayList<Bill> findList(String mst) throws SQLException {
 		ArrayList<Bill> list = new ArrayList();
 		java.sql.CallableStatement cs = con.prepareCall("SELECT * FROM bill WHERE maSoThue = " + mst);
		ResultSet rs = cs.executeQuery();
		while (rs.next()) {
			list.add(new Bill(rs.getString("idBill"),
					rs.getString("date"),
					rs.getString("luong"),
					rs.getString("songuoi"),
					rs.getString("maSoThue"),
					rs.getString("tienthue"),
					rs.getString("status")));
		}
		return list;
 	}
 		
    public long tinhTienThue (long soTinhthue, long soNgPhuthuoc) {
        if (soTinhthue < 0) throw new NumberFormatException();
        long tienThue = 0 ;
        if (soTinhthue > 11000000 ) {
            long ThuThapChiuThue = soTinhthue - 11000000 - soNgPhuthuoc * 4400000;
            if(ThuThapChiuThue > 80000000) {
                long bac1 = (5000000*5)/100;
                long bac2 = (10000000 - 5000000)*10/100;
                long bac3 = (18000000 - 10000000)*15/100;
                long bac4 = (32000000 - 18000000)*20/100;
                long bac5 = (52000000 - 32000000)*25/100;
                long bac6 = (80000000 - 52000000)*30/100;
                long bac7 = (ThuThapChiuThue - 80000000)*35/100;
                tienThue = bac1+bac2+bac3+bac4+bac5+bac6+bac7;
                return tienThue;
            }
            else if(ThuThapChiuThue > 52000000 && ThuThapChiuThue <= 80000000) {
                long bac1 = (5000000*5)/100;
                long bac2 = (10000000 - 5000000)*10/100;
                long bac3 = (18000000 - 10000000)*15/100;
                long bac4 = (32000000 - 18000000)*20/100;
                long bac5 = (52000000 - 32000000)*25/100;
                long bac6 = (ThuThapChiuThue - 52000000)*30/100;
                tienThue = bac1+bac2+bac3+bac4+bac5+bac6;
                return tienThue;
            }
            else if(ThuThapChiuThue > 32000000 && ThuThapChiuThue <= 52000000) {
                long bac1 = (5000000*5)/100;
                long bac2 = (10000000 - 5000000)*10/100;
                long bac3 = (18000000 - 10000000)*15/100;
                long bac4 = (32000000 - 18000000)*20/100;
                long bac5 = (ThuThapChiuThue - 32000000)*25/100;
                tienThue = bac1+bac2+bac3+bac4+bac5;
                return tienThue;
            }
            else if(ThuThapChiuThue > 18000000 && ThuThapChiuThue <= 32000000) {
                long bac1 = (5000000*5)/100;
                long bac2 = (10000000 - 5000000)*10/100;
                long bac3 = (18000000 - 10000000)*15/100;
                long bac4 = (ThuThapChiuThue - 18000000)*20/100;
                tienThue = bac1+bac2+bac3+bac4;
                return tienThue;
            }
            else if(ThuThapChiuThue > 10000000 && ThuThapChiuThue <= 18000000) {
                long bac1 = (5000000*5)/100;
                long bac2 = (10000000 - 5000000)*10/100;
                long bac3 = (ThuThapChiuThue - 10000000)*15/100;
                tienThue = bac1+bac2+bac3;
                return tienThue;
            }
            else if(ThuThapChiuThue <= 5000000 && ThuThapChiuThue > 0) {
                long bac1 = (ThuThapChiuThue*5)/100;
                tienThue = bac1;
                return tienThue;

            }
            else if(ThuThapChiuThue > 5000000 && ThuThapChiuThue <= 10000000) {
                long bac1 = (5000000*5)/100;
                long bac2 = (ThuThapChiuThue - 5000000)*10/100;
                tienThue = bac1+bac2;
                return tienThue;
            }
        }
        return tienThue;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
