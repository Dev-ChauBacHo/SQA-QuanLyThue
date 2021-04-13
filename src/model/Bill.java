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
	
	
	
	
}
