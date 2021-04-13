package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bill;
import dao.BillDao;

@WebServlet("/khaibao1")
public class khaibaoServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    private BillDao billDao;

    public void init() {
        billDao = new BillDao();
    }
    public long TinhTienThue (long soTinhthue ,long soNgPhuthuoc) {
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
        	else if(ThuThapChiuThue > 52000000 && ThuThapChiuThue < 80000000) {
        		long bac1 = (5000000*5)/100;
        		long bac2 = (10000000 - 5000000)*10/100;
        		long bac3 = (18000000 - 10000000)*15/100;
        		long bac4 = (32000000 - 18000000)*20/100;
        		long bac5 = (52000000 - 32000000)*25/100;
        		long bac6 = (ThuThapChiuThue - 52000000)*30/100;
        		tienThue = bac1+bac2+bac3+bac4+bac5+bac6;
        		return tienThue;
        	}
        	else if(ThuThapChiuThue > 32000000 && ThuThapChiuThue < 80000000) {
        		long bac1 = (5000000*5)/100;
        		long bac2 = (10000000 - 5000000)*10/100;
        		long bac3 = (18000000 - 10000000)*15/100;
        		long bac4 = (32000000 - 18000000)*20/100;
        		long bac5 = (ThuThapChiuThue - 32000000)*25/100;
        		tienThue = bac1+bac2+bac3+bac4+bac5;
        		return tienThue;
        	}
        	else if(ThuThapChiuThue > 18000000 && ThuThapChiuThue < 32000000) {
        		long bac1 = (5000000*5)/100;
        		long bac2 = (10000000 - 5000000)*10/100;
        		long bac3 = (18000000 - 10000000)*15/100;
        		long bac4 = (ThuThapChiuThue - 18000000)*20/100;
        		tienThue = bac1+bac2+bac3+bac4;
        		return tienThue;
        	}
        	else if(ThuThapChiuThue > 10000000 && ThuThapChiuThue < 18000000) {
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
        	else if(ThuThapChiuThue > 5000000 && ThuThapChiuThue < 10000000) {
        		long bac1 = (5000000*5)/100;
        		long bac2 = (ThuThapChiuThue - 5000000)*10/100;
        		tienThue = bac1+bac2;
        		return tienThue;
        	}
        }
		return tienThue;
        }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String date = request.getParameter("date");
        String mst = request.getParameter("mst");
        String luong = request.getParameter("luong");
        String tienthue = request.getParameter("tienthue");
        String songuoi = request.getParameter("songuoi");
        
        //luong
        //so nguoi phu thuoc
        long sosonguoi = Long.parseLong(songuoi);
        long soLuong = Long.parseLong(luong);
        String tienThue = String.valueOf(TinhTienThue(soLuong, sosonguoi));
        
        Bill bill = new Bill();
        bill.setDate(date);;
        bill.setMst(mst);
        bill.setLuong(luong);
        bill.setSonguoi(songuoi);
        bill.setTienThue(tienThue);
        
        try {
            int check = billDao.khaiBaoThue(bill);
            if (check != 0)
            	response.sendRedirect("khaibaosuccess.jsp");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

//        response.sendRedirect("employeedetails.jsp");
    }
}
