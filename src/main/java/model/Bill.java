package model;

import java.io.Serializable;

public class Bill implements Serializable {
	private static final long serialVersionUID = 1L;
	private String date;
	private String luong;
	private String songuoi;
	private String mst;
	private String tienThue;
	private boolean status;
	
	
	public Bill(String date, String luong, String songuoi, String tienThue, String mst, boolean status) {
		super();
		this.date = date;
		this.luong = luong;
		this.songuoi = songuoi;
		this.mst = mst;
		this.tienThue = tienThue;
		this.status = status;
	}
	
	
	public Bill() {
		super();
	}


	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getLuong() {
		return luong;
	}
	public void setLuong(String luong) {
		this.luong = luong;
	}
	public String getSonguoi() {
		return songuoi;
	}
	public void setSonguoi(String songuoi) {
		this.songuoi = songuoi;
	}
	public String getMst() {
		return mst;
	}
	public void setMst(String mst) {
		this.mst = mst;
	}
	public String getTienThue() {
		return tienThue;
	}
	public void setTienThue(String tienThue) {
		this.tienThue = tienThue;
	}


	@Override
	public String toString() {
		return "Bill [date=" + date + ", luong=" + luong + ", songuoi=" + songuoi + ", mst=" + mst + ", tienThue="
				+ tienThue + ", status=" + status + "]";
	}
	
	
	
	
}
